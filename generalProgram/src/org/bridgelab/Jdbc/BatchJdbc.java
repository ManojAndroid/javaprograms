package org.bridgelab.Jdbc;

import java.sql.*;

public class BatchJdbc {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String qry = "insert into abc.Student values(1230,'akash','singh')";
		//String qry = "Delete from abc.Student where id=1 OR 2 OR 3 OR 4";
		String qry1 = "insert into abc.Student values(1220,'uday','bigbro')";
		String fqry = "Select * from abc.Student";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=manoj");
			preparedStatement = connection.prepareStatement(qry);
			preparedStatement.addBatch();
			int[] ar = preparedStatement.executeBatch();

			preparedStatement = connection.prepareStatement(qry1);
			preparedStatement.addBatch();
			int[] ar1 = preparedStatement.executeBatch();

			resultSet = preparedStatement.executeQuery(fqry);
			while (resultSet.next()) {
				int fid = resultSet.getInt(1);
				String ffname = resultSet.getString(2);
				String fsname = resultSet.getString(3);
				System.out.println(fid + "\t" + ffname + "\t" + fsname);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
