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

@WebServlet("/update-player")
public class UpdatePlayerServlet extends GenericServlet{

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
			PreparedStatement pst = conn.prepareStatement("update player set playerName=?,age=?,nationality=?,iplTeam=?,iplSalary=? where playerId=?");
		
			pst.setString(1, recievedName);
			pst.setInt(2, recievedAge);
			pst.setString(3, recievedNationality);
			pst.setString(4, recievedTeam);
			pst.setInt(5, recievedSalary);
			pst.setInt(6, recievedId);
			int rowsInserted = pst.executeUpdate();
			
			PrintWriter pw = res.getWriter();
			pw.write(rowsInserted+" Data updated successfully!!");

			
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
