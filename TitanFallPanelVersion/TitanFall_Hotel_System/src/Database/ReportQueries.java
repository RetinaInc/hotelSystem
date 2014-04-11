package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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
	
	private int janCost,febCost,marCost,aprCost,mayCost,junCost,julCost,augCost,sepCost,octCost,novCost,decCost
	,janCost2,febCost2,marCost2,aprCost2,mayCost2,junCost2,julCost2,augCost2,sepCost2,octCost2,novCost2,decCost2
	,janCost3,febCost3,marCost3,aprCost3,mayCost3,junCost3,julCost3,augCost3,sepCost3,octCost3,novCost3,decCost3;
	
	private int numGolf,numSpa,numBreaky,numKarting;
	
	private int numSingles = 0,numDoubles = 0,numTwins = 0;
	private int cost4Single = 0,cost4Double = 0,cost4Twin = 0;
	private int total;
	
	private Date today = new Date();
	private Date arrivalDate,departureDate;
	private SimpleDateFormat f = new SimpleDateFormat ("dd.MM.yyyy");
	private SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss a ");
	
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
			System.out.println("numJan Bookings" + rset.getInt("numBookings"));
			 numJanBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-FEB-" + year + " ' and BOOKINGS.ARRIVALDATE <= '28-FEB-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numFeb Bookings" + rset.getInt("numBookings"));
			 numFebBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
					+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
					+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-MAR-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-MAR-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numMar Bookings" + rset.getInt("numBookings"));
			 numMarBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-APR-" + year + "' and BOOKINGS.ARRIVALDATE <= '30-APR-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numApr Bookings" + rset.getInt("numBookings"));
			 numAprBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-MAY-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-MAY-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numMay Bookings" + rset.getInt("numBookings"));
			 numMayBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-JUN-" + year + "' and BOOKINGS.ARRIVALDATE <= '30-JUN-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numJUN Bookings" + rset.getInt("numBookings"));
			 numJunBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-JUL-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-JUL-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numJul Bookings" + rset.getInt("numBookings"));
			 numJulBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-AUG-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-AUG-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numAug Bookings" + rset.getInt("numBookings"));
			 numAugBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-SEP-" + year + "' and BOOKINGS.ARRIVALDATE <= '30-SEP-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numSep Bookings" + rset.getInt("numBookings"));
			 numSepBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-OCT-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-OCT-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numOct Bookings" + rset.getInt("numBookings"));
			 numOctBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-NOV-" + year + "' and BOOKINGS.ARRIVALDATE <= '30-NOV-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numNov Bookings" + rset.getInt("numBookings"));
			 numNovBookings = rset.getInt("numBookings");
			
			sql = "select COUNT(ROOMTYPES.TYPE_ID) as numBookings from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
				+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER "
				+ "and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and ROOMTYPES.TYPE_ID = 900 "
					+ "and BOOKINGS.ARRIVALDATE >= '01-DEC-" + year + "' and BOOKINGS.ARRIVALDATE <= '31-DEC-" + year + "'";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numDec Bookings" + rset.getInt("numBookings"));
			 numDecBookings = rset.getInt("numBookings");
			 
			 //query to get the total cost of singles bookings for each month
			 sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
			 		+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
			 		+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-JAN-" + year + "' and b.ARRIVALDATE <= '31-JAN-" + year + "'";
 
			 pstmt = q.getConn().prepareStatement(sql);
				rset = pstmt.executeQuery();
				rset.next();
				System.out.println("janCost = " + rset.getInt("Total"));
				 janCost = rset.getInt("Total");
				 
				 sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					 		+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					 		+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-FEB-" + year + "' and b.ARRIVALDATE <= '28-FEB-" + year + "'";
		 
					 pstmt = q.getConn().prepareStatement(sql);
						rset = pstmt.executeQuery();
						rset.next();
						System.out.println("febCost = " + rset.getInt("Total"));
						 febCost = rset.getInt("Total");
						 
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
						+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
						+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-MAR-" + year + "' and b.ARRIVALDATE <= '31-MAR-" + year + "'";
				 
					pstmt = q.getConn().prepareStatement(sql);
					rset = pstmt.executeQuery();
					rset.next();
					System.out.println("marCost = " + rset.getInt("Total"));
					marCost = rset.getInt("Total");
								 
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-APR-" + year + "' and b.ARRIVALDATE <= '30-APR-" + year + "'";
					 
						pstmt = q.getConn().prepareStatement(sql);
						rset = pstmt.executeQuery();
						rset.next();
						System.out.println("aprCost = " + rset.getInt("Total"));
						aprCost = rset.getInt("Total");
						
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-MAY-" + year + "' and b.ARRIVALDATE <= '31-MAY-" + year + "'";
						 
					pstmt = q.getConn().prepareStatement(sql);
					rset = pstmt.executeQuery();
					rset.next();
					System.out.println("mayCost = " + rset.getInt("Total"));
					mayCost = rset.getInt("Total");
					
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-JUN-" + year + "' and b.ARRIVALDATE <= '30-JUN-" + year + "'";
					 
					pstmt = q.getConn().prepareStatement(sql);
					rset = pstmt.executeQuery();
					rset.next();
					System.out.println("junCost = " + rset.getInt("Total"));
					junCost = rset.getInt("Total");
						
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
						+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
						+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-JUL-" + year + "' and b.ARRIVALDATE <= '31-JUL-" + year + "'";
							 
						pstmt = q.getConn().prepareStatement(sql);
						rset = pstmt.executeQuery();
						rset.next();
						System.out.println("julCost = " + rset.getInt("Total"));
						julCost = rset.getInt("Total");
						
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-AUG-" + year + "' and b.ARRIVALDATE <= '31-AUG-" + year + "'";
									 
							pstmt = q.getConn().prepareStatement(sql);
							rset = pstmt.executeQuery();
							rset.next();
							System.out.println("augCost = " + rset.getInt("Total"));
							augCost = rset.getInt("Total");
							
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-SEP-" + year + "' and b.ARRIVALDATE <= '30-SEP-" + year + "'";
										 
							pstmt = q.getConn().prepareStatement(sql);
							rset = pstmt.executeQuery();
							rset.next();
							System.out.println("sepCost = " + rset.getInt("Total"));
							sepCost = rset.getInt("Total");
							
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-OCT-" + year + "' and b.ARRIVALDATE <= '31-OCT-" + year + "'";
										 
							pstmt = q.getConn().prepareStatement(sql);
							rset = pstmt.executeQuery();
							rset.next();
							System.out.println("octCost = " + rset.getInt("Total"));
							octCost = rset.getInt("Total");

					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-NOV-" + year + "' and b.ARRIVALDATE <= '30-NOV-" + year + "'";
										 
							pstmt = q.getConn().prepareStatement(sql);
							rset = pstmt.executeQuery();
							rset.next();
							System.out.println("novCost = " + rset.getInt("Total"));
							novCost = rset.getInt("Total");
							
					sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
							+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
							+ " and rt.TYPE_ID = 900 and b.ARRIVALDATE >= '01-DEC-" + year + "' and b.ARRIVALDATE <= '31-DEC-" + year + "'";
						 
							pstmt = q.getConn().prepareStatement(sql);
							rset = pstmt.executeQuery();
							rset.next();
							System.out.println("decCost = " + rset.getInt("Total"));
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
			System.out.println("numJan Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numFeb Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numMar Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numApr Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numMay Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numJUN Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numJul Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numAug Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numSep Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numOct Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numNov Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numDec Bookings" + rset.getInt("numBookings"));
			numDecBookings2 = rset.getInt("numBookings");
			
			//querys that get the total for doubles for each month
			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-JAN-"
					+ year + "' and b.ARRIVALDATE <= '31-JAN-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("janCost = " + rset.getInt("Total"));
			janCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-FEB-"
					+ year + "' and b.ARRIVALDATE <= '28-FEB-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("febCost = " + rset.getInt("Total"));
			febCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-MAR-"
					+ year + "' and b.ARRIVALDATE <= '31-MAR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("marCost = " + rset.getInt("Total"));
			marCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-APR-"
					+ year + "' and b.ARRIVALDATE <= '30-APR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("aprCost = " + rset.getInt("Total"));
			aprCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-MAY-"
					+ year + "' and b.ARRIVALDATE <= '31-MAY-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("mayCost = " + rset.getInt("Total"));
			mayCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-JUN-"
					+ year + "' and b.ARRIVALDATE <= '30-JUN-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("junCost = " + rset.getInt("Total"));
			junCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-JUL-"
					+ year + "' and b.ARRIVALDATE <= '31-JUL-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("julCost = " + rset.getInt("Total"));
			julCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-AUG-"
					+ year + "' and b.ARRIVALDATE <= '31-AUG-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("augCost = " + rset.getInt("Total"));
			augCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-SEP-"
					+ year + "' and b.ARRIVALDATE <= '30-SEP-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("sepCost = " + rset.getInt("Total"));
			sepCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-OCT-"
					+ year + "' and b.ARRIVALDATE <= '31-OCT-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("octCost = " + rset.getInt("Total"));
			octCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-NOV-"
					+ year + "' and b.ARRIVALDATE <= '30-NOV-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("novCost = " + rset.getInt("Total"));
			novCost2 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 901 and b.ARRIVALDATE >= '01-DEC-"
					+ year + "' and b.ARRIVALDATE <= '31-DEC-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("decCost = " + rset.getInt("Total"));
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
			System.out.println("numJan Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numFeb Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numMar Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numApr Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numMay Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numJUN Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numJul Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numAug Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numSep Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numOct Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numNov Bookings" + rset.getInt("numBookings"));
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
			System.out.println("numDec Bookings" + rset.getInt("numBookings"));
			numDecBookings3 = rset.getInt("numBookings");
			
			//get total for twins for each month
			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-JAN-"
					+ year + "' and b.ARRIVALDATE <= '31-JAN-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("janCost = " + rset.getInt("Total"));
			janCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-FEB-"
					+ year + "' and b.ARRIVALDATE <= '28-FEB-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("febCost = " + rset.getInt("Total"));
			febCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-MAR-"
					+ year + "' and b.ARRIVALDATE <= '31-MAR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("marCost = " + rset.getInt("Total"));
			marCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-APR-"
					+ year + "' and b.ARRIVALDATE <= '30-APR-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("aprCost = " + rset.getInt("Total"));
			aprCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-MAY-"
					+ year + "' and b.ARRIVALDATE <= '31-MAY-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("mayCost = " + rset.getInt("Total"));
			mayCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-JUN-"
					+ year + "' and b.ARRIVALDATE <= '30-JUN-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("junCost = " + rset.getInt("Total"));
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
			System.out.println("augCost = " + rset.getInt("Total"));
			augCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-SEP-"
					+ year + "' and b.ARRIVALDATE <= '30-SEP-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("sepCost = " + rset.getInt("Total"));
			sepCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-OCT-"
					+ year + "' and b.ARRIVALDATE <= '31-OCT-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("octCost = " + rset.getInt("Total"));
			octCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-NOV-"
					+ year + "' and b.ARRIVALDATE <= '30-NOV-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("novCost = " + rset.getInt("Total"));
			novCost3 = rset.getInt("Total");

			sql = "Select SUM(b.TOTAL_COST) AS Total From Bookings b,Rooms r,RoomTypes rt,ROOMBOOKINGS rb"
					+ " Where b.BOOKING_ID = rb.BOOKING_ID and rb.ROOM_NUMBER = r.ROOM_NUMBER and r.TYPE_ID = rt.TYPE_ID"
					+ " and rt.TYPE_ID = 902 and b.ARRIVALDATE >= '01-DEC-"
					+ year + "' and b.ARRIVALDATE <= '31-DEC-" + year + "'";

			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("decCost = " + rset.getInt("Total"));
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

		String trends = "\t\t\t\t\t\t\tTITANFALL TOWERS BOOKING TRENDS FOR 20" + year + "\r\nMonth\t\tSingle Room Bookings\t\tSingle Room Cost"
				+ "\t\tTotals for Singles\r\nJan\t\t\t" + numJanBookings + "\t\t\t\t€59.00\t\t\t\t€" + janCost + "\r\n"
				+ "Feb\t\t\t" + numFebBookings + "\t\t\t\t€59.00\t\t\t\t€" + febCost + "\r\n"
				+ "Mar\t\t\t" + numMarBookings + "\t\t\t\t€59.00\t\t\t\t€" + marCost + "\r\n" +
				"Apr\t\t\t" + numAprBookings + "\t\t\t\t€59.00\t\t\t\t€" + aprCost + "\r\n" +
				"May\t\t\t" + numMayBookings + "\t\t\t\t€59.00\t\t\t\t€" + mayCost + "\r\n" + 
				"Jun\t\t\t" + numJunBookings + "\t\t\t\t€59.00\t\t\t\t€" + junCost + "\r\n" +
				"Jul\t\t\t" + numJulBookings + "\t\t\t\t€59.00\t\t\t\t€" + julCost + "\r\n" + 
				"Aug\t\t\t" + numAugBookings + "\t\t\t\t€59.00\t\t\t\t€" + augCost + "\r\n" +
				"Sep\t\t\t" + numSepBookings + "\t\t\t\t€59.00\t\t\t\t€" + sepCost + "\r\n" +
				"Oct\t\t\t" + numOctBookings + "\t\t\t\t€59.00\t\t\t\t€" + octCost + "\r\n" +
				"Nov\t\t\t" + numNovBookings + "\t\t\t\t€59.00\t\t\t\t€" + novCost + "\r\n" +
				"Dec\t\t\t" + numDecBookings + "\t\t\t\t€59.00\t\t\t\t€" + decCost + "\r\n"
				+ "TOTAL\t\t\t\t\t\t\t\t\t\t\t€" + singlesTotal + "\r\n\r\n" +
				"Month\t\tDouble Room Bookings\t\tDouble Room Cost"
				+ "\t\tTotals for Doubles\r\n" +
				"Jan\t\t\t" + numJanBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + janCost2 + "\r\n"
				+ "Feb\t\t\t" + numFebBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + febCost2 + "\r\n"
				+ "Mar\t\t\t" + numMarBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + marCost2 + "\r\n" +
				"Apr\t\t\t" + numAprBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + aprCost2 + "\r\n" +
				"May\t\t\t" + numMayBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + mayCost2 + "\r\n" + 
				"Jun\t\t\t" + numJunBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + junCost2 + "\r\n" +
				"Jul\t\t\t" + numJulBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + julCost2 + "\r\n" + 
				"Aug\t\t\t" + numAugBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + augCost2 + "\r\n" +
				"Sep\t\t\t" + numSepBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + sepCost2 + "\r\n" +
				"Oct\t\t\t" + numOctBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + octCost2 + "\r\n" +
				"Nov\t\t\t" + numNovBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + novCost2 + "\r\n" +
				"Dec\t\t\t" + numDecBookings2 + "\t\t\t\t€99.00\t\t\t\t€" + decCost2 + "\r\n"
				+ "TOTAL\t\t\t\t\t\t\t\t\t\t\t€" + doublesTotal + "\r\n\r\n" +
				"Month\t\tTwin Room Bookings\t\tTwin Room Cost"
				+ "\t\t\tTotals for Twins\r\n" +
				"Jan\t\t\t" + numJanBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + janCost3 + "\r\n"
				+ "Feb\t\t\t" + numFebBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + febCost3 + "\r\n"
				+ "Mar\t\t\t" + numMarBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + marCost3 + "\r\n" +
				"Apr\t\t\t" + numAprBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + aprCost3 + "\r\n" +
				"May\t\t\t" + numMayBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + mayCost3 + "\r\n" + 
				"Jun\t\t\t" + numJunBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + junCost3 + "\r\n" +
				"Jul\t\t\t" + numJulBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + julCost3 + "\r\n" + 
				"Aug\t\t\t" + numAugBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + augCost3 + "\r\n" +
				"Sep\t\t\t" + numSepBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + sepCost3 + "\r\n" +
				"Oct\t\t\t" + numOctBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + octCost3 + "\r\n" +
				"Nov\t\t\t" + numNovBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + novCost3 + "\r\n" +
				"Dec\t\t\t" + numDecBookings3 + "\t\t\t\t€199.00\t\t\t\t€" + decCost3 + "\r\n"
				+ "TOTAL\t\t\t\t\t\t\t\t\t\t\t€" + twinsTotal + "\r\n\r\n"
				+"\r\n\r\nSaved on " + ft.format(today) + "\tby ";
		return trends;
	}
	
	public void specialsTrends(){
		try
		{
			String sql = "SELECT COUNT(Booking_ID) as numTimesBooked FROM SPECIALS where SPECIAL_ID = 11";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numGolf = " + rset.getInt("numTimesBooked"));
			numGolf = rset.getInt("numTimesBooked");
			
			sql = "SELECT COUNT(Booking_ID) as numTimesBooked FROM SPECIALS where SPECIAL_ID = 22";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numSpa = " + rset.getInt("numTimesBooked"));
			numSpa = rset.getInt("numTimesBooked");
			
			sql = "SELECT COUNT(Booking_ID) as numTimesBooked FROM SPECIALS where SPECIAL_ID = 33";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numBreaky = " + rset.getInt("numTimesBooked"));
			numBreaky = rset.getInt("numTimesBooked");
			
			sql = "SELECT COUNT(Booking_ID) as numTimesBooked FROM SPECIALS where SPECIAL_ID = 44";
			
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			System.out.println("numKarting = " + rset.getInt("numTimesBooked"));
			numKarting = rset.getInt("numTimesBooked");
		}
		catch(Exception e){
			System.out.println("could not get specials trends");
		}
		String specials = "\t\t\t\t\t\t\tTITANFALL TOWERS MOST POPULAR SPECIALS\r\n";
	}
	
	public String usersReceipt(){ //take in a booking object or just the bookingID
		try
		{
			q.open();
			String sql = "select ROOMTYPES.TYPE_NAME as type1,BOOKINGS.ARRIVALDATE as arrivalD,BOOKINGS.DEPARTUREDATE as departureD"
					+ ",BOOKINGS.TOTAL_COST as totalC,BOOKINGS.NUMBER_OF_NIGHTS as numNights"
					+ " from BOOKINGS,ROOMTYPES,ROOMBOOKINGS,ROOMS"
					+ " where BOOKINGS.BOOKING_ID = ROOMBOOKINGS.BOOKING_ID and ROOMBOOKINGS.ROOM_NUMBER = ROOMS.ROOM_NUMBER"
					+ " and ROOMS.TYPE_ID = ROOMTYPES.TYPE_ID and BOOKINGS.BOOKING_ID = " + 502;
			pstmt = q.getConn().prepareStatement(sql);
			rset = pstmt.executeQuery();
		
			
			while(rset.next()){
				System.out.println("here");
				if(rset.getString("type1").equals("Single")){
					numSingles++;
					cost4Single = 59 * rset.getInt("numNights");
				}
				else if(rset.getString("type1").equals("Double")){
					numDoubles++;
					cost4Double = 99 * rset.getInt("numNights");
				}
				else{
					numTwins++;
					cost4Twin = 199 * rset.getInt("numNights");
				}
				total = rset.getInt("totalC");
				arrivalDate = rset.getDate("arrivalD");
				departureDate = rset.getDate("departureD");
			}
		}
		catch(Exception e){
			System.out.println("could not make users receipt " + e);
		}
		String receipt2 = "\t\t\t\t\t\t\t\t\tTITANFALL TOWERS HOTEL\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tArrival Date\t" + f.format(arrivalDate) + "\r\n"
				+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tDeparture Date\t" + f.format(departureDate) + "\r\n\r\n"
		+ "\t\tQuantity\t\tDescription\t\t\t\tUnit Price\t\t\t\tAmount\r\n\t\t" + numSingles + "\t\t\tSingle Room\t\t\t\t€59.00\t\t\t\t\t€" + cost4Single
		+ "\r\n\t\t" + numDoubles + "\t\t\tDouble Room\t\t\t\t€99.00\t\t\t\t\t€" + cost4Double
		+ "\r\n\t\t" + numTwins + "\t\t\tTwin Room\t\t\t\t€199.00\t\t\t\t\t€" + cost4Twin + "\r\n\r\n\t\t\t\t\t\t\t\t\t\tSubtotal\t\t\t\t€" +
		total;
		return receipt2;
	}
}
