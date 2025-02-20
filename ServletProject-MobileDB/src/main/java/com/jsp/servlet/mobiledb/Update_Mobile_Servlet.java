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

public class Update_Mobile_Servlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String brand = req.getParameter("brand");
		String name = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));
		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/servlet_mobiledb?user=root&password=root");

			PreparedStatement pst = conn.prepareStatement("update mobile set mobileBrand = ?, mobileName = ?, mobilePrice = ? where mobileId = ? ");
			
			pst.setString(1, brand);
			pst.setString(2, name);
			pst.setInt(3, price);
			pst.setInt(4, id);

			int rowsUpdated = pst.executeUpdate();

			PrintWriter pw = res.getWriter();
			if (rowsUpdated > 0) {
				pw.write(rowsUpdated + "<h1> Data Updated Successfully</h1>");
			} else {
				pw.write("<h1> Data not Updated</h1> ");
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