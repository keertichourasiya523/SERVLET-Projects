package com.jsp.servlet.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/add-player")
public class AddPlayerServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int recievedId = Integer.parseInt(req.getParameter("id"));
		String recievedName = req.getParameter("name");
		int recievedAge = Integer.parseInt(req.getParameter("age"));
		String recievedNationality = req.getParameter("nationality");
		String recievedTeam = req.getParameter("team");
		int recievedSalary = Integer.parseInt(req.getParameter("salary"));
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/servlet_playerdb?user=root&password=root");
			PreparedStatement pst = conn.prepareStatement("insert into player values(?,?,?,?,?,?)");
			pst.setInt(1, recievedId);
			pst.setString(2, recievedName);
			pst.setInt(3, recievedAge);
			pst.setString(4, recievedNationality);
			pst.setString(5, recievedTeam);
			pst.setInt(6, recievedSalary);
			int rowsInserted = pst.executeUpdate();
			if(rowsInserted>0)
			{
				PrintWriter pw = res.getWriter();
				pw.write(rowsInserted+" Data added successfully!!");
				
			}
			
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
