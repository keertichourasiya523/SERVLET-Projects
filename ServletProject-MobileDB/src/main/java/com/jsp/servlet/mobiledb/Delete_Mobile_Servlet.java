package com.jsp.servlet.mobiledb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Delete_Mobile_Servlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/servlet_mobiledb?user=root&password=root");

			PreparedStatement pst = conn.prepareStatement("delete from mobile where mobileId=?");
			pst.setInt(1, id);
			

			boolean rowsDeleted = pst.execute();

			PrintWriter pw = res.getWriter();
			if(rowsDeleted!=true)
				pw.write(rowsDeleted + "<h1> Data Deleted Successfully</h1>");
	
			else
				pw.write("<h1> No Data Deleted </h1>");

		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
