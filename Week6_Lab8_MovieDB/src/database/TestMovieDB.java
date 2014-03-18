package database;

public class TestMovieDB {

	public static void main(String[] args) {
		MovieDB imdb = new MovieDB();
		imdb.openDB();
		imdb.dropTable();
		imdb.buildMovieTable();
		imdb.showDB();
		imdb.queryDB();
		imdb.closeDB();
	}
}
