package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import Model.Special;

public class specialsOperations {
	private PreparedStatement pstmt;
	private Queries q = new Queries();
	private ResultSet rset;
	private int numSpecials = 0;
	private Calendar today;
	private SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
	private String dayString,monthString,yearString;
	private int day,month,year;
	
	//this method takes in the month as an integer and returns the sting representation of it so it can
	//be used to compare departure dates to todays date
	public String getMonth(int month){
		String m = "";
		ArrayList<String> months = new ArrayList<String>();
		months.add("JAN");
		months.add("FEB");
		months.add("MAR");
		months.add("APR");
		months.add("MAY");
		months.add("JUN");
		months.add("JUL");
		months.add("AUG");
		months.add("SEP");
		months.add("OCT");
		months.add("NOV");
		months.add("DEC");
		
		for(int i = 0; i < months.size(); i++){
			m = months.get(month);
		}
		return m;
	}
	
	//method used to add a users special price to the total price in the bookings table
	//and add a booking on a special in the specialbookings table
		public void addSpecials(String[] names,int bookingid,double price){
			try
			{
				q.open();
				
				String sql = "Update Bookings set Total_Cost = Total_Cost + " + price + " where Booking_ID = " + bookingid;
				
				pstmt = q.getConn().prepareStatement(sql);
				pstmt.executeUpdate();
				
				ArrayList<Integer> ids = new ArrayList();
				//get the ids of the specials names that have been passed in
				
				for (int i = 0; i < names.length; i++) {
					sql = "Select Special_ID from Specials where Special_Name = '" + names[i] + "'";
					pstmt = q.getConn().prepareStatement(sql);
					rset = pstmt.executeQuery();
					
					//add the id for the names into the ids array list
					while(rset.next()){
						ids.add(rset.getInt("Special_ID"));
					}
				}
				
					sql = "Insert into SpecialBookings values(?,?,?)";
					pstmt = q.getConn().prepareStatement(sql);
					
					//insert each special booking into the specialsbookings table
					for (int i = 0; i < ids.size(); i++) {
						numSpecials++;
						pstmt.setInt(1, numSpecials);
						pstmt.setInt(2, ids.get(i));
						pstmt.setInt(3,bookingid );
						pstmt.executeUpdate();
					}
					
				System.out.println("Special cost added to booking ");
			}
			catch(Exception e){
				System.out.println("could not add special " + e);
				JOptionPane.showMessageDialog(null, "You have already added this special to this booking",
						"Error adding special",JOptionPane.ERROR_MESSAGE);
			}
			q.close();
		}
		
		public  int getLastRow() {
			q.open();
			
			String sqlStatement = "SELECT * FROM specials ORDER BY Special_ID";
			int specialID=0;
			try {
				pstmt = q.getConn().prepareStatement(sqlStatement,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				rset = pstmt.executeQuery();
				rset.last();
				System.out.println(rset.getInt("Special_ID"));
				specialID = rset.getInt("Special_ID");
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
			
			//q.close();
			return specialID;
			
		}
		
		//method to add a special to the specials table
		public void addSpecialsAdmin(Special s){
			try
			{
				q.open();
				String sql = "insert into specials values(?,?,?)";
				
				pstmt = q.getConn().prepareStatement(sql);
				pstmt.setInt(1, s.getSpeicalID());
				pstmt.setString(2, s.getSpecialName());
				pstmt.setDouble(3, s.getSpecialsCost());
				pstmt.executeUpdate();
				
				System.out.println(s.getSpecialName() + " added to specials table");
			}
			catch(Exception e){
				System.out.println("could not add special to specials " + e);
			}
			q.close();
		}
		
		public ArrayList<Object[]> getSpecials(){
			ArrayList<Object[]> specials = new ArrayList<Object[]>();
			try
			{
				q.open();
				String sql = "select * from specials";
				pstmt = q.getConn().prepareStatement(sql);
				rset = pstmt.executeQuery();
				
				while(rset.next()){
					Object[] b = {rset.getString("Special_Name"),
							rset.getDouble("Special_Cost")};
							
					specials.add(b);
				}
			}
			catch(Exception e){
				System.out.println("couldnt get specials");
			}
			q.close();
			return specials;
		}

		public void removeSpecial(String name) {
			try
			{
				q.open();
				
				today = Calendar.getInstance();
				String todaysDate = s.format(today.getTime());
				dayString = todaysDate.substring(0, 2);
				monthString = todaysDate.substring(3, 5);
				yearString =  todaysDate.substring(8, 10);
				
				day = Integer.parseInt(dayString);
				month = Integer.parseInt(monthString);
				month = month -1;			//subtract 1 to get precise month i.e 01 should be 00 to represent Jan
				year = Integer.parseInt(yearString);
				
				//check whether a special has a booking on it and whether the departure date hasnt already passed
				String sql = "select special_name from specials,specialbookings,BOOKINGS"
						+ " where specials.SPECIAL_ID = specialbookings.SPECIAL_ID "
						+ " and specialbookings.BOOKING_ID = BOOKINGS.BOOKING_ID "
						+ " and BOOKINGS.DEPARTUREDATE >= '" + day + "-" + getMonth(month) + "-" + year + "'"
						+ " and specials.SPECIAL_NAME = '" + name + "'";
				
				pstmt = q.getConn().prepareStatement(sql);
				
				rset = pstmt.executeQuery();
				//check to see if the special has a booking on it
				if(rset.next() == true){
					JOptionPane.showMessageDialog(null,name + " has a booking on it and cannot be removed",
						"Error deleting special",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					sql = "Delete from specials where Special_Name = '" + name + "'";
					pstmt = q.getConn().prepareStatement(sql);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, name + " was removed","Special Removed",
							JOptionPane.INFORMATION_MESSAGE);
				}
				System.out.println(name + " was removed");
			}
			catch(Exception e){
				System.out.println("error removing special " + e);
			}
			
		}
}
