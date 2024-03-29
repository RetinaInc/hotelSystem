package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ReportQueries {
	private Queries q = new Queries();
	private ResultSet rset;
	private PreparedStatement pstmt;
	private int numJanBookings,numFebBookings,numMarBookings,numAprBookings,numMayBookings,numJunBookings,numJulBookings,numAugBookings
	,numSepBookings,numOctBookings,numNovBookings,numDecBookings,
	numJanBookings2,numFebBookings2,numMarBookings2,numAprBookings2,numMayBookings2,numJunBookings2,numJulBookings2,numAugBookings2
	,numSepBookings2,numOctBookings2,numNovBookings2,numDecBookings2,
	numJanBookings3,numFebBookings3,numMarBookings3,numAprBookings3,numMayBookings3,numJunBookings3,numJulBookings3,numAugBookings3
	,numSepBookings3,numOctBookings3,numNovBookings3,numDecBookings3;
	
	private double janCost,febCost,marCost,aprCost,mayCost,junCost,julCost,augCost,sepCost,octCost,novCost,decCost
	,janCost2,febCost2,marCost2,aprCost2,mayCost2,junCost2,julCost2,augCost2,sepCost2,octCost2,novCost2,decCost2
	,janCost3,febCost3,marCost3,aprCost3,mayCost3,junCost3,julCost3,augCost3,sepCost3,octCost3,novCost3,decCost3;

	private int numSingles = 0,numDoubles = 0,numTwins = 0;
	private double cost4Single = 0,cost4Double = 0,cost4Twin = 0;
	private double total;
	private double specialsCost;
	
	private Date today = new Date();
	private Date arrivalDate,departureDate;
	private SimpleDateFormat f = new SimpleDateFormat ("dd.MM.yyyy");
	private SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss a ");
	private ArrayList<String> names = new ArrayList<String>();     //used to get the names of the specials a particular user has for a booking
	private ArrayList<Double> costs = new ArrayList<Double>();     //used to get the costs of the specials a particular user has for a booking
	private ArrayList<Integer> amount = new ArrayList<Integer>();     //used to keep track of the amount of times a booking was booked
	private DecimalFormat df = new DecimalFormat("###,###.00");
	
	public String getBookingTrends(int year){
		//Start of singles calculations from number of bookings per month and the total for each month
		String sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
				+ "and BOOKINGS.ARRIVALDATE >= '01-JAN-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-JAN-" + year + "'";
		try
		{
			q.open();
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			 numJanBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-FEB-" + year + " ' and BOOKINGS.ARRIVALDATE <= '28-FEB-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			 numFebBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
					+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
					+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-MAR-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-MAR-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			 numMarBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-APR-" + year + "' and BOOKINGS.ARRIVALDATE <= '30-APR-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			 numAprBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-MAY-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-MAY-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			 numMayBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-JUN-" + year + "' and BOOKINGS.ARRIVALDATE <= '30-JUN-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			 numJunBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-JUL-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-JUL-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			 numJulBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-AUG-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-AUG-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			 numAugBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-SEP-" + year + "' and BOOKINGS.ARRIVALDATE <= '30-SEP-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			 numSepBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-OCT-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-OCT-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			 numOctBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-NOV-" + year + "' and BOOKINGS.ARRIVALDATE <= '30-NOV-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			 numNovBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-DEC-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-DEC-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numDecBookings = rset.getInt("numBookings");
			 
			 //query to get the total cost of singles bookings for each month
			 sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
			 		+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
			 		+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-JAN-" + year + "' and b.ARRIVALDATE <= '31-JAN-" + year + "'";
 
			 pstmt = q.getConn().prepareStatement(sql);
				rset = pstmt.executeQuery();
				rset.next();
				janCost = rset.getInt("Total");
				 
				 sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					 		+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					 		+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-FEB-" + year + "' and b.ARRIVALDATE <= '28-FEB-" + year + "'";
		 
					 pstmt = q.getConn().prepareStatement(sql);
						rset = pstmt.executeQuery();
						rset.next();
						febCost = rset.getInt("Total");
						 
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
						+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
						+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-MAR-" + year + "' and b.ARRIVALDATE <= '31-MAR-" + year + "'";
				 
					pstmt = q.getConn().prepareStatement(sql);
					rset = pstmt.executeQuery();
					rset.next();
					marCost = rset.getInt("Total");
								 
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-APR-" + year + "' and b.ARRIVALDATE <= '30-APR-" + year + "'";
					 
						pstmt = q.getConn().prepareStatement(sql);
						rset = pstmt.executeQuery();
						rset.next();
						aprCost = rset.getInt("Total");
						
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-MAY-" + year + "' and b.ARRIVALDATE <= '31-MAY-" + year + "'";
						 
					pstmt = q.getConn().prepareStatement(sql);
					rset = pstmt.executeQuery();
					rset.next();
					mayCost = rset.getInt("Total");
					
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-JUN-" + year + "' and b.ARRIVALDATE <= '30-JUN-" + year + "'";
					 
					pstmt = q.getConn().prepareStatement(sql);
					rset = pstmt.executeQuery();
					rset.next();
					junCost = rset.getInt("Total");
						
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
						+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
						+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-JUL-" + year + "' and b.ARRIVALDATE <= '31-JUL-" + year + "'";
							 
						pstmt = q.getConn().prepareStatement(sql);
						rset = pstmt.executeQuery();
						rset.next();
						julCost = rset.getInt("Total");
						
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-AUG-" + year + "' and b.ARRIVALDATE <= '31-AUG-" + year + "'";
									 
							pstmt = q.getConn().prepareStatement(sql);
							rset = pstmt.executeQuery();
							rset.next();
							augCost = rset.getInt("Total");
							
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-SEP-" + year + "' and b.ARRIVALDATE <= '30-SEP-" + year + "'";
										 
							pstmt = q.getConn().prepareStatement(sql);
							rset = pstmt.executeQuery();
							rset.next();
							sepCost = rset.getInt("Total");
							
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-OCT-" + year + "' and b.ARRIVALDATE <= '31-OCT-" + year + "'";
										 
							pstmt = q.getConn().prepareStatement(sql);
							rset = pstmt.executeQuery();
							rset.next();
							octCost = rset.getInt("Total");

					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-NOV-" + year + "' and b.ARRIVALDATE <= '30-NOV-" + year + "'";
										 
							pstmt = q.getConn().prepareStatement(sql);
							rset = pstmt.executeQuery();
							rset.next();
							novCost = rset.getInt("Total");
							
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-DEC-" + year + "' and b.ARRIVALDATE <= '31-DEC-" + year + "'";
						 
							pstmt = q.getConn().prepareStatement(sql);
							rset = pstmt.executeQuery();
							rset.next();
							decCost = rset.getInt("Total");
			
			//calculations for number of bookings made on double rooms for each month				
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-JAN-"
					+ year
					+ " ' and BOOKINGS.ARRIVALDATE <= '31-JAN-" + year + "'";
							
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numJanBookings2 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-FEB-"
					+ year
					+ " ' and BOOKINGS.ARRIVALDATE <= '28-FEB-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numFebBookings2 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-MAR-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-MAR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numMarBookings2 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-APR-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '30-APR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numAprBookings2 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-MAY-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-MAY-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numMayBookings2 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-JUN-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '30-JUN-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numJunBookings2 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-JUL-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-JUL-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numJulBookings2 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-AUG-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-AUG-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numAugBookings2 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-SEP-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '30-SEP-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numSepBookings2 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-OCT-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-OCT-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numOctBookings2 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-NOV-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '30-NOV-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numNovBookings2 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 901 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-DEC-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-DEC-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numDecBookings2 = rset.getInt("numBookings");
			
			//querys that get the total for doubles for each month
			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-JAN-"
					+ year + "' and b.ARRIVALDATE <= '31-JAN-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			janCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-FEB-"
					+ year + "' and b.ARRIVALDATE <= '28-FEB-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			febCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-MAR-"
					+ year + "' and b.ARRIVALDATE <= '31-MAR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			marCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-APR-"
					+ year + "' and b.ARRIVALDATE <= '30-APR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			aprCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-MAY-"
					+ year + "' and b.ARRIVALDATE <= '31-MAY-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			mayCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-JUN-"
					+ year + "' and b.ARRIVALDATE <= '30-JUN-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			junCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-JUL-"
					+ year + "' and b.ARRIVALDATE <= '31-JUL-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			julCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-AUG-"
					+ year + "' and b.ARRIVALDATE <= '31-AUG-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			augCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-SEP-"
					+ year + "' and b.ARRIVALDATE <= '30-SEP-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			sepCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-OCT-"
					+ year + "' and b.ARRIVALDATE <= '31-OCT-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			octCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-NOV-"
					+ year + "' and b.ARRIVALDATE <= '30-NOV-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			novCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-DEC-"
					+ year + "' and b.ARRIVALDATE <= '31-DEC-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			decCost2 = rset.getInt("Total");
			
			//querys to get total number of bookings made on twin rooms for each month
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-JAN-"
					+ year
					+ " ' and BOOKINGS.ARRIVALDATE <= '31-JAN-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numJanBookings3 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-FEB-"
					+ year
					+ " ' and BOOKINGS.ARRIVALDATE <= '28-FEB-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numFebBookings3 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-MAR-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-MAR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numMarBookings3 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-APR-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '30-APR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numAprBookings3 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-MAY-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-MAY-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numMayBookings3 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-JUN-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '30-JUN-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numJunBookings3 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-JUL-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-JUL-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numJulBookings3 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-AUG-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-AUG-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numAugBookings3 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-SEP-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '30-SEP-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numSepBookings3 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-OCT-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-OCT-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numOctBookings3 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-NOV-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '30-NOV-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numNovBookings3 = rset.getInt("numBookings");

			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 902 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-DEC-"
					+ year
					+ "' and BOOKINGS.ARRIVALDATE <= '31-DEC-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			numDecBookings3 = rset.getInt("numBookings");
			
			//get total for twins for each month
			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-JAN-"
					+ year + "' and b.ARRIVALDATE <= '31-JAN-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			janCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-FEB-"
					+ year + "' and b.ARRIVALDATE <= '28-FEB-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			febCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-MAR-"
					+ year + "' and b.ARRIVALDATE <= '31-MAR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			marCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-APR-"
					+ year + "' and b.ARRIVALDATE <= '30-APR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			aprCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-MAY-"
					+ year + "' and b.ARRIVALDATE <= '31-MAY-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			mayCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-JUN-"
					+ year + "' and b.ARRIVALDATE <= '30-JUN-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			junCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-JUL-"
					+ year + "' and b.ARRIVALDATE <= '31-JUL-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("julCost = " + rset.getInt("Total"));
			julCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-AUG-"
					+ year + "' and b.ARRIVALDATE <= '31-AUG-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			augCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-SEP-"
					+ year + "' and b.ARRIVALDATE <= '30-SEP-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			sepCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-OCT-"
					+ year + "' and b.ARRIVALDATE <= '31-OCT-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			octCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-NOV-"
					+ year + "' and b.ARRIVALDATE <= '30-NOV-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			novCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-DEC-"
					+ year + "' and b.ARRIVALDATE <= '31-DEC-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			decCost3 = rset.getInt("Total");
		}
		catch(Exception e){
			System.out.println("error getting booking trends for 20" + year + "\t" + e);
		}
		//these 3 variables take the cost from each month and calculate the total for the year
		//for a specific room type
		double singlesTotal = janCost + febCost + marCost + aprCost + mayCost + junCost + julCost + augCost + sepCost + octCost
				+ novCost + decCost;
		double doublesTotal = janCost2 + febCost2 + marCost2 + aprCost2 + mayCost2 + junCost2 + julCost2 + augCost2 + sepCost2 + octCost2
				+ novCost2 + decCost2;
		double twinsTotal = janCost3 + febCost3 + marCost3 + aprCost3 + mayCost3 + junCost3 + julCost3 + augCost3 + sepCost3 + octCost3
				+ novCost3 + decCost3;
		
		//these 3 variables add the number of rooms for each month of each type
		//and calculate how many of this room type was booked for the year
		//this allows the admin to see which is the most popular room and when
		
		int numSingles = numJanBookings + numFebBookings + numMarBookings + numAprBookings + numMayBookings + numJunBookings
				+ numJulBookings + numAugBookings + numSepBookings + numOctBookings + numNovBookings + numDecBookings;
		int numDoubles = numJanBookings2 + numFebBookings2 + numMarBookings2 + numAprBookings2 + numMayBookings2 + numJunBookings2
				+ numJulBookings2 + numAugBookings2 + numSepBookings2 + numOctBookings2 + numNovBookings2 + numDecBookings2;
		int numTwins = numJanBookings3 + numFebBookings3 + numMarBookings3 + numAprBookings3 + numMayBookings3 + numJunBookings3
				+ numJulBookings3 + numAugBookings3 + numSepBookings3 + numOctBookings3 + numNovBookings3 + numDecBookings3;

		String trends = "\t\t\t\t\t\t\tTITANFALL TOWERS BOOKING TRENDS FOR 20" + year + "\r\n\r\nMonth\t\tSingle Room Bookings\t\tSingle Room Cost"
				+ "\t\tTotals for Singles\r\nJan\t\t\t" + numJanBookings + "\t\t\t\t�59.00\t\t\t\t�" + janCost + "\r\n"
				+ "Feb\t\t\t" + numFebBookings + "\t\t\t\t�59.00\t\t\t\t�" + febCost + "\r\n"
				+ "Mar\t\t\t" + numMarBookings + "\t\t\t\t�59.00\t\t\t\t�" + marCost + "\r\n" +
				"Apr\t\t\t" + numAprBookings + "\t\t\t\t�59.00\t\t\t\t�" + aprCost + "\r\n" +
				"May\t\t\t" + numMayBookings + "\t\t\t\t�59.00\t\t\t\t�" + mayCost + "\r\n" + 
				"Jun\t\t\t" + numJunBookings + "\t\t\t\t�59.00\t\t\t\t�" + junCost + "\r\n" +
				"Jul\t\t\t" + numJulBookings + "\t\t\t\t�59.00\t\t\t\t�" + julCost + "\r\n" + 
				"Aug\t\t\t" + numAugBookings + "\t\t\t\t�59.00\t\t\t\t�" + augCost + "\r\n" +
				"Sep\t\t\t" + numSepBookings + "\t\t\t\t�59.00\t\t\t\t�" + sepCost + "\r\n" +
				"Oct\t\t\t" + numOctBookings + "\t\t\t\t�59.00\t\t\t\t�" + octCost + "\r\n" +
				"Nov\t\t\t" + numNovBookings + "\t\t\t\t�59.00\t\t\t\t�" + novCost + "\r\n" +
				"Dec\t\t\t" + numDecBookings + "\t\t\t\t�59.00\t\t\t\t�" + decCost + "\r\n"
				+ "TOTAL\t\t\t" + numSingles + "\t\t\t\t\t\t\t\t�" + singlesTotal + "\r\n\r\n" +
				"Month\t\tDouble Room Bookings\t\tDouble Room Cost"
				+ "\t\tTotals for Doubles\r\n" +
				"Jan\t\t\t" + numJanBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + janCost2 + "\r\n"
				+ "Feb\t\t\t" + numFebBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + febCost2 + "\r\n"
				+ "Mar\t\t\t" + numMarBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + marCost2 + "\r\n" +
				"Apr\t\t\t" + numAprBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + aprCost2 + "\r\n" +
				"May\t\t\t" + numMayBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + mayCost2 + "\r\n" + 
				"Jun\t\t\t" + numJunBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + junCost2 + "\r\n" +
				"Jul\t\t\t" + numJulBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + julCost2 + "\r\n" + 
				"Aug\t\t\t" + numAugBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + augCost2 + "\r\n" +
				"Sep\t\t\t" + numSepBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + sepCost2 + "\r\n" +
				"Oct\t\t\t" + numOctBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + octCost2 + "\r\n" +
				"Nov\t\t\t" + numNovBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + novCost2 + "\r\n" +
				"Dec\t\t\t" + numDecBookings2 + "\t\t\t\t�99.00\t\t\t\t�" + decCost2 + "\r\n"
				+ "TOTAL\t\t\t" + numDoubles + "\t\t\t\t\t\t\t\t�" + doublesTotal + "\r\n\r\n" +
				"Month\t\tTwin Room Bookings\t\tTwin Room Cost"
				+ "\t\t\tTotals for Twins\r\n" +
				"Jan\t\t\t" + numJanBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + janCost3 + "\r\n"
				+ "Feb\t\t\t" + numFebBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + febCost3 + "\r\n"
				+ "Mar\t\t\t" + numMarBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + marCost3 + "\r\n" +
				"Apr\t\t\t" + numAprBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + aprCost3 + "\r\n" +
				"May\t\t\t" + numMayBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + mayCost3 + "\r\n" + 
				"Jun\t\t\t" + numJunBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + junCost3 + "\r\n" +
				"Jul\t\t\t" + numJulBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + julCost3 + "\r\n" + 
				"Aug\t\t\t" + numAugBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + augCost3 + "\r\n" +
				"Sep\t\t\t" + numSepBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + sepCost3 + "\r\n" +
				"Oct\t\t\t" + numOctBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + octCost3 + "\r\n" +
				"Nov\t\t\t" + numNovBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + novCost3 + "\r\n" +
				"Dec\t\t\t" + numDecBookings3 + "\t\t\t\t�199.00\t\t\t\t�" + decCost3 + "\r\n"
				+ "TOTAL\t\t\t" + numTwins + "\t\t\t\t\t\t\t\t�" + twinsTotal + "\r\n\r\n"
				+"\r\n\r\nSaved on " + ft.format(today) + "\tby ";
		q.close();
		return trends;
	}
	
	
	////////////////////////////////////////////////////////////////////////////
	//Special Trends
	///////////////////////////////////////////////////////////////////////////
	public String specialsTrends(int year){
		try
		{
			q.open();
			String sql = "SELECT Special_ID  FROM SPECIALS";
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			ArrayList<Integer> ids = new ArrayList<Integer>();
			//put all of the ids retreaved into an array list
			while(rset.next()){
				ids.add(rset.getInt("Special_ID"));
			}
			
			//get the number of bookings on each special within a year
			for (int i = 0; i < ids.size(); i++) {
				 sql = 
				 "SELECT COUNT(SPECIALBOOKINGS.Booking_ID) as numTimesBooked " +
				 "FROM SPECIALBOOKINGS,BOOKINGS " + 
				 "where SPECIALBOOKINGS.BOOKING_ID = BOOKINGS.BOOKING_ID " +
				 "and SPECIAL_ID = " + ids.get(i) +
				 " and BOOKINGS.ARRIVALDATE >= '01-JAN-" + year +  "' " +
				 " and BOOKINGS.DEPARTUREDATE <= '31-DEC-" + year + "'";
				
				pstmt = q.getConn().prepareStatement(sql);
				rset = pstmt.executeQuery();
				
				while(rset.next()){
					amount.add(rset.getInt("numTimesBooked"));
				}
			}
			
		//get the names of each special using their id
			sql = "SELECT Special_Name,Special_Cost FROM SPECIALS";
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()){
				names.add(rset.getString("Special_Name"));
				costs.add(rset.getDouble("Special_Cost"));
			}
		}
		catch(Exception e){
			System.out.println("could not get specials trends " + e.getMessage());
			e.printStackTrace();
		}
		String specials = "\t\t\t\t\t\t\t\tTITANFALL TOWERS MOST POPULAR SPECIALS 20" + year + "\r\n\r\n"
				+ "\t\tSpecial Name\t\t\tSpecial Cost\t\tAmount of Bookings on this Special\r\n";
		int total = 0;
		for (int i = 0; i < names.size(); i++) {
			String special = String.format("\t\t%-20s\t\t�%-9.2f\t\t\t\t%d\r\n", names.get(i),costs.get(i),amount.get(i));
			specials = specials + special;
			total = total + amount.get(i);
		}
		specials = specials + "\t\t\t\t\t\tTotal Specials Booked\t\t\t" + total;
		q.close();
		return specials;
	}
	
	
	////////////////////////////////////////////////////////////////////////////
	//USERS RECEIPT
	///////////////////////////////////////////////////////////////////////////
	public String usersReceipt(int id){ 
		try
		{
			q.open();
			String sql = "select ROOMTYPES.TYPE_NAME as type1,BOOKINGS.ARRIVALDATE as arrivalD,BOOKINGS.DEPARTUREDATE as departureD"
					+ ",BOOKINGS.NUMBER_OF_NIGHTS as numNights,BOOKINGS.TOTAL_COST as Total"
					+ " from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
					+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER"
					+ " and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and BOOKINGS.BOOKING_ID = " + id;
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
		
			
			while(rset.next()){
				if(rset.getString("type1").equals("Single")){
					numSingles++;
					cost4Single = (59 * rset.getInt("numNights")) * numSingles;
				}
				else if(rset.getString("type1").equals("Double")){
					numDoubles++;
					cost4Double = (99 * rset.getInt("numNights")) * numDoubles;
				}
				else{
					numTwins++;
					cost4Twin = (199 * rset.getInt("numNights")) * numTwins;
				}
				total = cost4Single + cost4Double + cost4Twin;
				arrivalDate = rset.getDate("arrivalD");
				departureDate = rset.getDate("departureD");
			}
			sql = "select SPECIALS.SPECIAL_NAME as Name,SPECIALS.SPECIAL_COST as Cost from SPECIALBOOKINGS,SPECIALS "
					+ "where SPECIALS.SPECIAL_ID = SPECIALBOOKINGS.SPECIAL_ID "
					+ "and BOOKING_ID = " + id;

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery(); //if a result set is returned it means the user has specials
			
			//add the cost of the special to the specials cost and add the name and cost of the special to their
			//arrays
			
			while(rset.next()){
				names.add(rset.getString("Name")); //add the name of the special to the array
				costs.add(rset.getDouble("Cost")); //add the cost of the special to the array
				specialsCost = specialsCost + rset.getDouble("Cost");
			}
		}
		catch(Exception e){
			System.out.println("could not make users receipt " + e);
		}
		String single = "",doubles = "",twin = "",specials = "";
		if(numSingles > 0){
			 single = "\r\n\t\t" + numSingles + "\t\t\tSingle Room\t\t\t\t�59.00\t\t\t\t\t�" + df.format(cost4Single);
		}
		 if(numDoubles > 0){
			 doubles = "\r\n\t\t" + numDoubles + "\t\t\tDouble Room\t\t\t\t�99.00\t\t\t\t\t�" + df.format(cost4Double);
		}
		 if(numTwins > 0){
			 twin = "\r\n\t\t" + numTwins + "\t\t\tTwin Room\t\t\t\t�199.00\t\t\t\t\t�" + df.format(cost4Twin);
		}
		 if(names.size() > 0){
			 specials = "\r\n\r\n\r\n\t\t\t\t\t\t\t\t\tSPECIALS YOU HAVE CHOSEN\r\n";
			 for (int i = 0; i < names.size(); i++) {
				 String special = String.format("\r\n\t\t1\t\t\t%-20s\t\t\t\t\t�%9.2f", names.get(i),costs.get(i));
				specials = specials + special;
			}
		 }
		String receipt2 = "\t\t\t\t\t\t\t\t\tTITANFALL TOWERS HOTEL\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tArrival Date\t" + f.format(arrivalDate) + "\r\n"
				+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tDeparture Date\t" + f.format(departureDate) + "\r\n\r\n"
		+ "\t\tQuantity\t\tDescription\t\t\t\tUnit Price\t\t\t\tAmount" + single + doubles + twin + specials
		+ "\r\n\r\n\t\t\t\t\t\t\t\t\t\tTotal\t\t\t\t\t�" + df.format((total + specialsCost))
		+"\r\n\r\n\t\t\t\t\t\t\t\t\t\tVAT\t\t\t\t\t�" 
		+ df.format(((total + specialsCost) * 21 / 100)) + "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t---------\r\n"
		+ "\r\n\t\t\t\t\t\t\t\t\t\tSubtotal\t\t\t\t�" + df.format(((total + specialsCost) + ((total + specialsCost) * 21 / 100)));
		q.close();
		return receipt2;
	}
}
