package Database;
public class TestDB {
	public static void main(String[] args) {
		DropTables dt = new DropTables();
		dt.dropTables();
		CreateTables t = new CreateTables();
		t.buildUserTable();
		t.buildHotelTable();
		t.buildBookingsTable();
		t.buildRoomTypesTable();
		t.bulidRoomsTable();
		t.buildRoomBookingsTable();
		t.buildCreditCardsTable();
		t.buildSpecialsTable();
//		t.queryDB();
	}
}