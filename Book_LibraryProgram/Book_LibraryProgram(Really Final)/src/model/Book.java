package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.Parameter;

/**
 * This class enables getting, setting, and interacting with the user's inputs.
 * This class also interacts with the database to search, create, update and delete
 * the information given by the user.
 * @author Seokwoo Ha
 *
 */
public class Book {
	/**
	 * This is the row ID of a book.
	 */
	private int rowID;

	/**
	 * This is the Author of a book.
	 */
	private String author;

	/**
	 * This is the Title of a book.
	 */
	private String title;

	/**
	 * This is the Genre of a book.
	 */
	private String genre;

	/**
	 * This is the Location of a book.
	 */
	private String location;

	/**
	 *
	 * @return the rowID of the book
	 */
	public int getRowID() {
		return rowID;
	}

	/**
	 * 
	 * @param pRowID the rowID to set
	 */
	public void setRowID(final int pRowID) {
		rowID = pRowID;
	}

	/**
	 *
	 * @return the author of the book
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 
	 * @param pAuthor the author to set
	 */
	public void setAuthor(final String pAuthor) {
		author = pAuthor;
	}

	/**
	 *
	 * @return the title of the book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param pTitle the title to set
	 */
	public void setTitle(final String pTitle) {
		title = pTitle;
	}

	/**
	 *
	 * @return the genre of the book
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * 
	 * @param pGenre the genre to set
	 */
	public void setGenre(final String pGenre) {
		genre = pGenre;
	}

	/**
	 *
	 * @return the location of the book
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 
	 * @param pLocation the location to set
	 */
	public void setLocation(final String pLocation) {
		location = pLocation;
	}

	/**
	 * 
	 * @return returnBooks Set a list of all books.
	 */
	public static List<Book> getAllBooks() {
		Database db = new Database();
		List<Book> returnBooks = new ArrayList<>();
		try {
			db.getResultSet("library.usp_GetAllBooks");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnBooks;
	}

	/**
	 * 
	 * @return searchResults Get a list of all books.
	 */
	public static List<Book> getAllBooklists() {

		Database db = new Database();
		List<Parameter> params = new ArrayList<>();
		List<Book> searchResults = new ArrayList<>();
		try {
			ResultSet rsBook = db.getResultSet("library.usp_GetAllBooks", params);
			while (rsBook.next()) {
				Book b = new Book();
				b.setRowID(rsBook.getInt("rowID"));
				b.setAuthor(rsBook.getString("Author"));
				b.setTitle(rsBook.getString("Title"));
				b.setGenre(rsBook.getString("Genre"));
				b.setLocation(rsBook.getString("Location"));
				searchResults.add(b);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong");
		}
		return searchResults;
	}

	/**
	 * Create a book from the user's inputs.
	 * @throws SQLException Throws error messages if error exists.
	 */
	public final void create() throws SQLException {
		Database db = new Database();
		List<Parameter> params = new ArrayList<>();

		try {
			params.add(new Parameter<String>(author));
			params.add(new Parameter<String>(title));
			params.add(new Parameter<String>(genre));
			params.add(new Parameter<String>(location));

			ResultSet rsNewBook = db.getResultSet("library.usp_CreateBook", params);
			if (rsNewBook.next()) {
				rowID = rsNewBook.getInt("RowID");

			}
		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong");

		}

	}

	/**
	 * Update a book from the user's inputs.
	 */
	public final void update() {
		Database db = new Database();
		List<Parameter> params = new ArrayList<>();

		try {
			params.add(new Parameter<Integer>(rowID));
			params.add(new Parameter<String>(author));
			params.add(new Parameter<String>(title));
			params.add(new Parameter<String>(genre));
			params.add(new Parameter<String>(location));

			db.executeSql("library.usp_UpdateBook", params);

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong");

		}
	}

	/**
	 * Check whether the input is an integer or not.
	 * @param s Input from the user.
	 * @return isValidInteger
	 */
	public static boolean isInteger(final String s) {
		boolean isValidInteger = false;
		try {
			Integer.parseInt(s);

			// s is a valid integer

			isValidInteger = true;
		} catch (NumberFormatException ex) {
			// s is not an integer
		}

		return isValidInteger;
	}

	/**
	 * Search books by any inputs.
	 * @param stringAny Input from the user.
	 * @return searchResults
	 */
	public static List<Book> searchByAny(final String stringAny) {

		Database db = new Database();
		List<Parameter> params = new ArrayList<>();
		List<Book> searchResults = new ArrayList<>();
		try {

			params.add(new Parameter<String>(stringAny));

			ResultSet rsBook = db.getResultSet("library.usp_FindBooks", params);
			while (rsBook.next()) {
				Book b = new Book();
				b.setRowID(rsBook.getInt("rowID"));
				b.setAuthor(rsBook.getString("Author"));
				b.setTitle(rsBook.getString("Title"));
				b.setGenre(rsBook.getString("Genre"));
				b.setLocation(rsBook.getString("Location"));
				searchResults.add(b);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong");
		}
		return searchResults;

	}

	/**
	 * Search books by row ID.
	 * @param pRowID Getting row ID from the user.
	 * @return searchResults
	 */
	public static List<Book> searchByRowID(final int pRowID) {

		Database db = new Database();
		List<Parameter> params = new ArrayList<>();
		List<Book> searchResults = new ArrayList<>();
		try {

			params.add(new Parameter<Integer>(pRowID));

			ResultSet rsBook = db.getResultSet("library.usp_GetBook", params);
			while (rsBook.next()) {
				Book b = new Book();
				b.setRowID(rsBook.getInt("rowID"));
				b.setAuthor(rsBook.getString("Author"));
				b.setTitle(rsBook.getString("Title"));
				b.setGenre(rsBook.getString("Genre"));
				b.setLocation(rsBook.getString("Location"));
				searchResults.add(b);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong");
		}
		return searchResults;

	}

	/**
	 * Search books by author.
	 * @param stringAuthor Input author from the user.
	 * @return searchResults
	 */
	public static List<Book> searchByAuthor(final String stringAuthor) {

		Database db = new Database();
		List<Parameter> params = new ArrayList<>();
		List<Book> searchResults = new ArrayList<>();
		try {

			params.add(new Parameter<String>(stringAuthor));

			ResultSet rsBook = db.getResultSet("library.usp_FindBooksByAuthor", params);
			while (rsBook.next()) {
				Book b = new Book();
				b.setRowID(rsBook.getInt("rowID"));
				b.setAuthor(rsBook.getString("Author"));
				b.setTitle(rsBook.getString("Title"));
				b.setGenre(rsBook.getString("Genre"));
				b.setLocation(rsBook.getString("Location"));
				searchResults.add(b);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong");
		}
		return searchResults;

	}

	/**
	 * Search books by title.
	 * @param stringTitle Input title from the user.
	 * @return searchResults
	 */
	public static List<Book> searchByTitle(final String stringTitle) {

		Database db = new Database();
		List<Parameter> params = new ArrayList<>();
		List<Book> searchResults = new ArrayList<>();
		try {

			params.add(new Parameter<String>(stringTitle));

			ResultSet rsBook = db.getResultSet("library.usp_FindBooksByTitle", params);
			while (rsBook.next()) {
				Book b = new Book();
				b.setRowID(rsBook.getInt("rowID"));
				b.setAuthor(rsBook.getString("Author"));
				b.setTitle(rsBook.getString("Title"));
				b.setGenre(rsBook.getString("Genre"));
				b.setLocation(rsBook.getString("Location"));
				searchResults.add(b);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong");
		}
		return searchResults;

	}

	/**
	 * Search books by genre.
	 * @param stringGenre Input genre from the user.
	 * @return searchResults
	 */
	public static List<Book> searchByGenre(final String stringGenre) {

		Database db = new Database();
		List<Parameter> params = new ArrayList<>();
		List<Book> searchResults = new ArrayList<>();
		try {

			params.add(new Parameter<String>(stringGenre));

			ResultSet rsBook = db.getResultSet("library.usp_FindBooksByGenre", params);
			while (rsBook.next()) {
				Book b = new Book();
				b.setRowID(rsBook.getInt("rowID"));
				b.setAuthor(rsBook.getString("Author"));
				b.setTitle(rsBook.getString("Title"));
				b.setGenre(rsBook.getString("Genre"));
				b.setLocation(rsBook.getString("Location"));
				searchResults.add(b);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong");
		}
		return searchResults;

	}

	/**
	 * Search books by location.
	 * @param stringLocation Input location from the user.
	 * @return searchResults
	 */
	public static List<Book> searchByLocation(final String stringLocation) {

		Database db = new Database();
		List<Parameter> params = new ArrayList<>();
		List<Book> searchResults = new ArrayList<>();
		try {

			params.add(new Parameter<String>(stringLocation));

			ResultSet rsBook = db.getResultSet("library.usp_FindBooksByLocation", params);
			while (rsBook.next()) {
				Book b = new Book();
				b.setRowID(rsBook.getInt("rowID"));
				b.setAuthor(rsBook.getString("Author"));
				b.setTitle(rsBook.getString("Title"));
				b.setGenre(rsBook.getString("Genre"));
				b.setLocation(rsBook.getString("Location"));
				searchResults.add(b);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong");
		}
		return searchResults;

	}

	/**
	 * Delete books.
	 */
	public final void delete() {
		Database db = new Database();
		List<Parameter> params = new ArrayList<>();

		try {
			params.add(new Parameter<Integer>(rowID));

			db.executeSql("library.usp_DeleteBook", params);

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong");
		}
	}

}
