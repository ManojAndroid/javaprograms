package org.bridgelab.Jdbc;

import java.sql.*;
import java.util.Scanner;

public class Transaction {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = scanner.nextInt();
		System.out.println("Enter the First Name");
		String fname = scanner.next();
		System.out.println("Enter the Second Name");
		String sname = scanner.next();
		
		System.out.println("Enter the branch Name");
		String branch = scanner.next();
		System.out.println("Enter the college id");
		int cid = scanner.nextInt();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet resultSet = null;

		String qry = "insert into abc.Student values(?,?,?)";
		String fqry = "insert into abc.college values(?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=manoj");
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(qry);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, fname);
			preparedStatement.setString(3, sname);
			preparedStatement.executeUpdate();

			System.out.println("Student data base operation");
			preparedStatement1 = connection.prepareStatement(fqry);

			preparedStatement1.setInt(1, id);
			preparedStatement1.setString(2, branch);
			preparedStatement1.executeUpdate();
			System.out.println("college data base operation");
			System.out.println("_________________________");
			  resultSet = preparedStatement.executeQuery(fqry); 
			  connection.commit();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				connection.rollback();
				System.out.println("rollback called");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();

			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if (preparedStatement != null)
				try {
					resultSet.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if (connection != null)
				try {
					resultSet.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
	}

}
