package org.bridgelab.Jdbc;

import java.sql.*;
import java.util.Scanner;

public class PrepStatement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = scanner.nextInt();
		System.out.println("Enter the First Name");
		String fname = scanner.next();
		System.out.println("Enter the Second Name");
		String sname = scanner.next();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String qry = "insert into abc.Student values(?,?,?)";
		String fqry = "Select * from abc.Student";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=manoj");

			preparedStatement = connection.prepareStatement(qry);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, fname);
			preparedStatement.setString(3, sname);
			preparedStatement.executeUpdate();

			System.out.println("Data  inserted Successfully");

			resultSet = preparedStatement.executeQuery(fqry);
			while (resultSet.next()) {
				int fid = resultSet.getInt(1);
				String ffname = resultSet.getString(2);
				String fsname = resultSet.getString(3);
				System.out.println(fid + "\t" + ffname + "\t" + fsname);
			}

		} catch (ClassNotFoundException | SQLException e) {
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
