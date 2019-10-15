package com.excel.Sample.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.Random;
import java.net.*;
import java.io.*;

/**
 * Servlet implementation class ExcelSample
 */
public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatePost() {
		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
				try {
String title=request.getParameter("title");
String desc=request.getParameter("desc");
String tempid=request.getParameter("tempid");
Random rnd = new Random();
   int n = 100000 + rnd.nextInt(900000);


	String url = "jdbc:postgresql://ec2-23-21-160-80.compute-1.amazonaws.com:5432/d4ovlnqvutd1j7";
        Connection conn = 							DriverManager.getConnection(url,"ckimwlfkyjkcvd","8a898408823185c78744e7bd54d71c87a4b0953ccd7271657265386796e24cbd");
    ResultSet resultSet = conn.prepareStatement("select id,userid from users where tempid='"+tempid+"'").executeQuery();
 int id=0;
String userid="";
while(resultSet.next()){
id=resultSet.getInt("id" );
userid=resultSet.getString("userid" );
   PreparedStatement ps = conn.prepareStatement("INSERT INTO posts(title,desc,userid) VALUES ( ?, ?, ?)");
   ps.setString(1, title );
   ps.setString(2, desc );
   ps.setString(3,userid );
   ps.executeUpdate();
   ps.close();

   
   PreparedStatement pss = conn.prepareStatement("update users set tempid='"+n+"' where id='"+id+"'");
   pss.executeUpdate();
   pss.close();

 
}  
resultSet.close();
conn.close();
		out.println("id:"+id);
response.sendRedirect("dashboard.jsp?id="+id+"&tempid="+n);
				} catch (Exception e) {
					out.println("Excel Sample : "+e);
				}
			
		

	}
public static byte[] readFully(InputStream input) throws IOException
{
    byte[] buffer = new byte[8192];
    int bytesRead;
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    while ((bytesRead = input.read(buffer)) != -1)
    {
        output.write(buffer, 0, bytesRead);
    }
    return output.toByteArray();
}

	public static String readJsonFromUrl(String theUrl) {
    StringBuilder content = new StringBuilder();
    try
    {
      URL url = new URL(theUrl);
      URLConnection urlConnection = url.openConnection();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      String line;
      while ((line = bufferedReader.readLine()) != null)
      {
        content.append(line + "\n");
      }
      bufferedReader.close();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    return content.toString();
	}
}
