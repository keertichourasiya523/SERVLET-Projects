package com.jsp.servlet.mobiledb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Find_Mobile_Servlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/servlet_mobiledb?user=root&password=root");

			PreparedStatement pst = conn.prepareStatement("select * from mobile where mobileId = ? ");
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();

			PrintWriter pw = res.getWriter();
			
			while(rs.next())
			{
				pw.write(rs.getInt(1)+"\t");
				pw.write(rs.getString(2)+"\t");
				pw.write(rs.getString(3)+"\t");
				pw.write(rs.getInt(4)+"\t");
			}

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
