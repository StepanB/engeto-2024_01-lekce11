package org.example;

import org.example.database.SchoolTable;

import java.sql.*;

public class Main {

	private static final String connectionString = "jdbc:mysql://localhost:13306/school";
	private static final String SELECT_ALL_STUDENTS = "SELECT * FROM Courses";

	public static void main(String[] args) throws SQLException {

		Connection connection = DriverManager.getConnection(connectionString, "root", "heslo123");

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(SELECT_ALL_STUDENTS);

		while (resultSet.next()) {
			String nazev = resultSet.getString(SchoolTable.NAZEV);
			int idKurzu = resultSet.getInt(1);
			System.out.println(idKurzu + ": " + nazev);
		}

		getStudent("Stepan", statement);

		boolean execute = statement.execute("INSERT INTO Students (jmeno, prijmeni) VALUES('Stepan', 'Bohm')");

		connection.close();

	}

	private static void getStudent(String nameOfStudent, Statement statement) throws SQLException {
		ResultSet resultSet;
		resultSet = statement.executeQuery("SELECT * FROM Students WHERE jmeno = '"+nameOfStudent+"'");
		while (resultSet.next()) {
			String nazev = resultSet.getString("jmeno");
			System.out.println(nazev);
		}
	}
}