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
import javax.servlet.http.*;  

/**
 * Servlet implementation class ExcelSample
 */
public class UpdatePosts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePosts() {
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
String purl=request.getParameter("url");
String p_id=request.getParameter("p_id");
String id=request.getParameter("id");
String nn=request.getParameter("nn");



					 String url = "jdbc:postgresql://ec2-23-21-160-80.compute-1.amazonaws.com:5432/d4ovlnqvutd1j7";
            Connection conn = 							DriverManager.getConnection(url,"ckimwlfkyjkcvd","8a898408823185c78744e7bd54d71c87a4b0953ccd7271657265386796e24cbd");


   PreparedStatement ps = conn.prepareStatement("update posts set p_display_url='"+purl+"' where p_id='"+p_id+"'");
   ps.executeUpdate();
   ps.close();
out.println("success");
    HttpSession session=request.getSession();  
        session.setAttribute("id",id); 
response.sendRedirect("dashboard.jsp?id="+id+"&tempid="+nn);


				} catch (Exception e) {
					out.println("UpdatePosts : "+e);
				}
			
		

	}


}
