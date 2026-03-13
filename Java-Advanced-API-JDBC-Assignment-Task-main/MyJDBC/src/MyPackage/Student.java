package MyPackage;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {
	public void createDatabase() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String password = "anant6350";
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, userName, password);

			Statement stm = conn.createStatement();

			String query = "create database db1";
			stm.execute(query);
			System.out.println("Database created Successfully ");

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createTable() {
		try {
			String url = "jdbc:mysql://localhost:3306/db1";
//			String db = "db1";
			String userName = "root";
			String password = "anant6350";
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, userName, password);

			Statement stm = conn.createStatement();

			String query = "create table student1 (sid int(3), sname varchar(15), semail varchar(15))";

			stm.execute(query);
			System.out.println("Table created Successfully ");

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createData() {
		try {
			String url = "jdbc:mysql://localhost:3306/db1";
//			String db = "db1";
			String userName = "root";
			String password = "anant6350";
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, userName, password);

//			Statement stm = conn.createStatement();
//			String query = "INSERT into student1 VALUES (2,'Ansh', 'ansh@gmail.com')";
			String query = "INSERT into student1 (sid, sname, semail) VALUES (?,?,?)";

			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, 10);
			pstm.setString(2, "Shivam");
			pstm.setString(3, "shivam@gmail.com");

//			stm.execute(query);
			pstm.execute();

			System.out.println("Data inserted Successfully ");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readData() {
		try {
			String url = "jdbc:mysql://localhost:3306/db1";
//			String db = "db1";
			String userName = "root";
			String password = "anant6350";
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, userName, password);

//			Statement stm = conn.createStatement();
//			String query = "INSERT into student1 VALUES (2,'Ansh', 'ansh@gmail.com')";
			String query = "Select * from student1";

			Statement stm = conn.createStatement();

//			stm.execute(query);
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				System.out.println("Id = " + rs.getInt(1));
				System.out.println("name = " + rs.getString(2));
				System.out.println("email = " + rs.getString(3));
			}
			System.out.println("Read successfully" + rs);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateData() {
		try {
			String url = "jdbc:mysql://localhost:3306/db1";
			String userName = "root";
			String password = "anant6350";

			Connection conn = DriverManager.getConnection(url, userName, password);

			String query = "UPDATE student1 set sid = ? where sname = ?";

			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, 11);
			pstm.setString(2, "Shivam");

//		stm.execute(query);
			pstm.execute();

			System.out.println("Data updated Successfully ");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteData() {
		try {
		String url = "jdbc:mysql://localhost:3306/db1";
		String userName = "root";
		String password = "anant6350";

		Connection conn = DriverManager.getConnection(url, userName, password);

		String query = "DELETE from student1 where sid = ?";

		PreparedStatement pstm = conn.prepareStatement(query);
		pstm.setInt(1, 11);

		pstm.execute();

		System.out.println("Data deleted Successfully ");
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
