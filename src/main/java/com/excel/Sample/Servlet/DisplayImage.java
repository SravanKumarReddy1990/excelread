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

public class DisplayImage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	try 
        {
		String imgid = request.getParameter("imgid");

		byte[] byteImg = null;
String imgname="";
 
					 String url = "jdbc:postgresql://ec2-23-21-160-80.compute-1.amazonaws.com:5432/d4ovlnqvutd1j7";
            Connection connection = 							DriverManager.getConnection(url,"ckimwlfkyjkcvd","8a898408823185c78744e7bd54d71c87a4b0953ccd7271657265386796e24cbd");
   PreparedStatement ps = connection.prepareStatement("SELECT image,name FROM images WHERE id = ?");
   ps.setInt(1, Integer.parseInt(imgid));
  ResultSet rs = ps.executeQuery();
   while (rs.next()) {
    byteImg = rs.getBytes(1);
imgname=rs.getString(2);
   }
   rs.close();
   ps.close();
connection.close();

		
		response.setContentType("image/png");
		response.setContentLength(byteImg.length);
		
		OutputStream outStream = response.getOutputStream();

		outStream.write(byteImg);

		outStream.flush();
		outStream.close();
	}
        catch(Exception e) 
        {
            e.printStackTrace();
        }
	}
}
