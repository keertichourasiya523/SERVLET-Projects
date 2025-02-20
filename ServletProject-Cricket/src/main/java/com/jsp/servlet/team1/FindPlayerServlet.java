package com.jsp.servlet.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/find-player")
public class FindPlayerServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int recievedId = Integer.parseInt(req.getParameter("id"));
	
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/servlet_playerdb?user=root&password=root");
			PreparedStatement pst = conn.prepareStatement("select * from player where playerId=?");
			pst.setInt(1, recievedId);

			ResultSet rs = pst.executeQuery();
			PrintWriter pw = res.getWriter();
			while(rs.next()) {
				pw.print(rs.getInt(1)+"\t");
				pw.print(rs.getString(2)+"\t");
				pw.print(rs.getInt(3)+"\t");
				pw.print(rs.getString(4)+"\t");
				pw.print(rs.getString(5)+"\t");
				pw.print(rs.getInt(6)+"\t");
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
