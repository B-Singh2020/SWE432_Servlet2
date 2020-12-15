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
@WebServlet(name = "final", urlPatterns = {"/final"})


public class finalWebApp extends HttpServlet {
	
	static String Domain = "swe432-servlet2.herokuapp.com/";
	static String Path = "/";
	static String Servlet = "final";
	static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";
	
	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html"); // Tells the web container what we're sending back
		PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window
		 out.println("<body>");
		   out.println("<p>");
		   out.println("String List Sorter");
		   out.println("</p>");
		   out.print  ("<form method=\"post\"");
		   out.println(" action=\"/" + Servlet + "\">");
		   out.println("");
		   out.println(" <table>");
		   out.println("  <tr>");
		   out.println("   <td>List Items:");
		   out.println("   <td><input type=\"text\" name=\"FS\" value=\"" + 0 + "\" size=5>");
		   out.println("  </tr>");
		   out.println("  <tr>");
		 
		   out.println("  <tr>");
		   out.println("   <td>Order:");
		   out.println("   <td><input type=\"radio\" name=\"order\" value=\"" + "Ascending Order" + "\"checked> Ascending Order </input>");
		   out.println("   <td><input type=\"radio\" name=\"order\" value=\"" + "Descending Order" + "\"> Descending Order </input>");
		   
		  
		   out.println("  </tr>");
		   out.println(" </table>");
		   out.println(" <br>");
		   out.println(" <br>");
		   out.println(" <input type=\"submit\" value=\"" + "Sort" + "\" name=\"Operation\">");
		   out.println(" <input type=\"reset\" value=\"Reset\" name=\"reset\">");
		   out.println("</form>");
		   out.println("");
		   out.println("</body>");
		
		
		
		
	}
	
	

}
