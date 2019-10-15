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
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();

		// TODO Auto-generated constructor stubs
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
String password=request.getParameter("passwords");
String userid=request.getParameter("email");
Random rnd = new Random();
int n = 100000 + rnd.nextInt(900000);
String tempid=n+"";


					 String url = "jdbc:postgresql://ec2-23-21-160-80.compute-1.amazonaws.com:5432/d4ovlnqvutd1j7";
            Connection conn = 							DriverManager.getConnection(url,"ckimwlfkyjkcvd","8a898408823185c78744e7bd54d71c87a4b0953ccd7271657265386796e24cbd");

ResultSet resultSet = conn.prepareStatement("select id from users where userid='"+userid+"' and password='"+password+"'").executeQuery();
 int id=0;
while(resultSet.next()){
id=resultSet.getInt("id" );

   PreparedStatement ps = conn.prepareStatement("update users tempid='"+tempid+"' where userid='"+userid+"'");
   ps.executeUpdate();
   ps.close();


}  
resultSet.close();
conn.close();
out.println("id:"+id);
response.sendRedirect("dashboard.html?id="+id+"&tempid="+tempid);
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
