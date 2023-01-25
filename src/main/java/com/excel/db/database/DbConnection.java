package com.excel.db.database;

import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public Connection getDbConnection() throws IOException, SQLException {
		Properties props = getDbProperties();

		Connection con = null;
		con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"),
				props.getProperty("password"));

		return con;

	}

	public Properties getDbProperties() throws IOException {
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					new File("C:\\Users\\MPawar\\Desktop\\mahesh\\learnings\\java\\git_projects\\Excel-DB-App\\files",
							"db.properties"));
			props.load(fis);
		} catch (FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());

		}
		return props;

	}

	public int getRowCount(String tablename) throws IOException, SQLException {
		Connection con = getDbConnection();
		int rowCount = 0;
		if (con == null) {
			System.out.println("Connection to Database is Failed");
			return 0;
		}
		String query = "select count(1) from " + tablename;

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);

		if (rs.next()) {
			rowCount = rs.getInt(1);
		}

		return rowCount;
	}

}
