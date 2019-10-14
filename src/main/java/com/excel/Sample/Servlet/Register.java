package com.excel.Sample.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.sql.*;
import java.util.Random;
import java.net.*;
import java.io.*;

/**
 * Servlet implementation class ExcelSample
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
String name=request.getParameter("name");
String password=request.getParameter("password");
String userid=request.getParameter("userid");
Random rnd = new Random();
int n = 100000 + rnd.nextInt(900000);
String tempid=n+"";

Random rnd = new Random();
int n = 100000 + rnd.nextInt(900000);
					 String url = "jdbc:postgresql://ec2-23-21-160-80.compute-1.amazonaws.com:5432/d4ovlnqvutd1j7";
            Connection conn = 							DriverManager.getConnection(url,"ckimwlfkyjkcvd","8a898408823185c78744e7bd54d71c87a4b0953ccd7271657265386796e24cbd");
   Statement statement = conn.createStatement();
   PreparedStatement ps = conn.prepareStatement("INSERT INTO users(name,password,userid,tempid) VALUES (?, ?, ?, ?)");
   ps.setInt(1, name );
   ps.setString(2, password );
   ps.setString(3, userid );
   ps.setString(4,tempid );
   ps.executeUpdate();
   ps.close();

  PreparedStatement ps1 = conn.prepareStatement("select id from users where userid='"+userid+"'");
  String id= ps1.getString("id" );
   ps1.close();

conn.close();
		out.println("id:"+id);			
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
