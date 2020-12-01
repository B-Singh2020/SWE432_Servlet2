package servlet;


import javax.servlet.*; // servlet library

import javax.servlet.http.*; // servlet library
import java.io.*;
import javax.servlet.annotation.WebServlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
// The @WebServletannotation is used to declare a servlet
@WebServlet(name = "prax", urlPatterns = {"/prax"})

public class praxFinal {
	
	static String Domain = "swe432-servlet2.herokuapp.com/";
	static String Path = "/";
	static String Servlet = "prax";
	static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";
	
	
	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html"); // Tells the web container what we're sending back
		PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window
		 out.println("<p> hello </p>");
		
		
		
		
	}
	
	
	

}
