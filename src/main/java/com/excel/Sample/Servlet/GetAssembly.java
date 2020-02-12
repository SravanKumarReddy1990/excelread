package com.excel.Sample.Servlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.io.*;

public class GetAssembly extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	try 
        {
PrintWriter out = response.getWriter();
		String lat = request.getParameter("lat");
		String longi = request.getParameter("longi");
String text="";
 
String url = "jdbc:postgresql://ec2-23-21-160-80.compute-1.amazonaws.com:5432/d4ovlnqvutd1j7";
Connection connection = 							DriverManager.getConnection(url,"ckimwlfkyjkcvd","8a898408823185c78744e7bd54d71c87a4b0953ccd7271657265386796e24cbd");
    PreparedStatement ps = connection.prepareStatement("SELECT St_AsText(geom) FROM \"India_AC_TS_parliament\" WHERE ST_Within(ST_GeomFromText('POINT("+longi+" "+lat+")'), geom)");

  ResultSet rs = ps.executeQuery();
   while (rs.next()) {
   text = rs.getString(1);
   }
   rs.close();
   ps.close();
out.println(text);
connection.close();

		
		
	}
        catch(Exception e) 
        {
            e.printStackTrace();
        }
	}
}
