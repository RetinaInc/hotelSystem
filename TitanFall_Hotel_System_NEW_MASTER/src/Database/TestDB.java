package Database;
public class TestDB {
	public static void main(String[] args) {
		
		
		DropTables dt = new DropTables();
		dt.dropTables();
		
		CreateTables t = new CreateTables();
		t.buildTitanFallTables();
		
		t.queryDB();
		
		t.getHotel();

		/* commented out because getUsers method also prints out all the users to the console */
//		t.getUsers();
	}
}