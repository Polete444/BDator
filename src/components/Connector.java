package components;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public interface Connector {
	/**
	 * Create the connection for dataBase.
	 * 
	 * @param driver        String with driver for database.
	 * @param urlConnection String url with link to the database.
	 * @param user          String userName of database.
	 * @param password      String password of database.
	 * @return Connection with database. Null if something was wrong.
	 */
	public Connection createConnection(String driver, String urlConnection, String user, String password);
	// https://alvinalexander.com/java/java-mysql-select-query-example
	// https://www.javatpoint.com/example-to-connect-to-the-mysql-database

	/**
	 * Create Statement for database.
	 * 
	 * @param connection with database connection.
	 * @return Statement. Null if something was wrong.
	 */
	public Statement createStatement(Connection connection);

	/**
	 * Execute Query and return all data on ResultSet.
	 * 
	 * @param query     String.
	 * @param statement Statement from database.
	 * @return ResultSet with data, or null object if failed.
	 */
	public ResultSet executeQuery(String query, Statement statement);

	/**
	 * Process all data from query and return ArrayList of DataContainer.
	 * 
	 * @param dataType   ArrayList<String> with all data sorted.
	 * @param dataFields ArrayList<String> with fields of Database.
	 * @param dataJava   Result of execute query.
	 * @return ArrayList<DataContainer> with all data sorted as input.
	 */
	public ArrayList<DataContainer> processData(ArrayList<String> dataType, ArrayList<String> dataFields,
			ResultSet dataJava);

	/**
	 * Close the statements after use it.
	 * 
	 * @param statement of database
	 * @return return True if its closed okay, False if something happens.
	 */
	public boolean closeStatement(Statement statement);
}
