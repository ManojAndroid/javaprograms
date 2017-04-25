package org.bridgelab.Jdbc;

import java.sql.*;

public class StatementDemo {
	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String ary = "delete from abc.Student where id=100";
		String qry = "Select * from abc.Student";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver calss loaded");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=manoj");
			statement = connection.createStatement();
			statement.execute(ary);
			System.out.println("Dtata is inserted Sucessfully");
			resultSet = statement.executeQuery(qry);
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String fname = resultSet.getString(2);
				String sname = resultSet.getString(3);
				System.out.println(id + "\t" + fname + "\t" + sname);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}

	}
}
