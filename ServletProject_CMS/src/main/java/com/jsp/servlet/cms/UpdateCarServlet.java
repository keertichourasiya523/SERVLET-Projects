package com.jsp.servlet.cms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save-updated-car")
public class UpdateCarServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int carId = Integer.parseInt(req.getParameter("carId"));
		String model = req.getParameter("model");
		String brand = req.getParameter("brand");
		String color = req.getParameter("color");
		int price = Integer.parseInt(req.getParameter("price"));
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/servlet_cardb?user=root&password=root");
			PreparedStatement pst = conn.prepareStatement("update car set model=?,brand=?,color=?,price=? where carId=?");
			pst.setString(1, model);
			pst.setString(2, brand);
			pst.setString(3, color);
			pst.setInt(4, price);
			pst.setInt(5, carId);
			
			pst.execute();
			
			resp.sendRedirect("display-all-cars");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		

		
		
	}

}
