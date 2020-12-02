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

public class praxFinal extends HttpServlet {
	
	static String Domain = "swe432-servlet2.herokuapp.com/";
	static String Path = "/";
	static String Servlet = "prax";
	static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";
	
	
	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html"); // Tells the web container what we're sending back
		PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window
		 out.println("<body>");
		   out.println("<p>");
		   out.println("Three String Concatenator");
		   out.println("</p>");
		   out.print  ("<form method=\"post\"");
		   out.println(" action=\"/" + Servlet + "\">");
		   out.println("");
		   out.println(" <table>");
		   out.println("  <tr>");
		   out.println("   <td>Value A:");
		   out.println("   <td><input type=\"text\" name=\"FS\" value=\"" + 0 + "\" size=5>");
		   out.println("  </tr>");
		   out.println("  <tr>");
		   out.println("   <td>Value B:");
		   out.println("   <td><input type=\"text\" name=\"SS\" value=\"" + 0 + "\" size=5>");
		   out.println("  </tr>");
		   out.println("  <tr>");
		   out.println("   <td>Value C:");
		   out.println("   <td><input type=\"text\" name=\"TS\" value=\"" + 0 + "\" size=6>");
		   out.println("  </tr>");
		  
		   out.println("  <tr>");
		   out.println("   <td>Order:");
		   out.println("   <td><input type=\"radio\" name=\"order\" value=\"" + "ABC" + "\"checked> ABC </input>");
		   out.println("   <td><input type=\"radio\" name=\"order\" value=\"" + "ACB" + "\"> ACB </input>");
		   out.println("   <td><input type=\"radio\" name=\"order\" value=\"" + "BAC" + "\"> BAC </input>");
		   out.println("   <td><input type=\"radio\" name=\"order\" value=\"" + "BCA" + "\"> BCA </input>");
		   out.println("   <td><input type=\"radio\" name=\"order\" value=\"" + "CAB" + "\"> CAB </input>");
		   out.println("   <td><input type=\"radio\" name=\"order\" value=\"" + "CBA" + "\"> CBA </input>");
		   out.println("  </tr>");
		   out.println(" </table>");
		   out.println(" <br>");
		   out.println(" <br>");
		   out.println(" <input type=\"submit\" value=\"" + "Concat" + "\" name=\"Operation\">");
		   out.println(" <input type=\"submit\" value=\"" + "Separate" + "\" name=\"Operation\">");
		   out.println(" <input type=\"submit\" value=\"" + "Reverse" + "\" name=\"Operation\">");
		   out.println(" <input type=\"reset\" value=\"Reset\" name=\"reset\">");
		   out.println("</form>");
		   out.println("");
		   out.println("</body>");
		
		
		
		
	}
	
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String[] val1;
		val1 = request.getParameterValues("ops1");
		String[] v1 = request.getParameterValues("v1");
		String operation = request.getParameter("Operation");
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String r = "";
		String ord = request.getParameter("order");
		s1 = request.getParameter("FS");
		s2 = request.getParameter("SS");
		s3 = request.getParameter("TS");
		
	    if(operation.equals("Separate"))
	    {
	    	s1 = s1 + ".";
	    	s2 = s2 + ".";
	    	s3 = s3 + ".";
	    }
	    
	    if(operation.equals("Reverse"))
	    {
	    	 StringBuilder input1 = new StringBuilder();
	    	 input1.append(s1);
	    	 input1.reverse();
	    	 s1 = input1.toString();
	    	 
	    	 StringBuilder input2 = new StringBuilder();
	    	 input2.append(s2);
	    	 input2.reverse();
	    	 s2 = input2.toString();
	    	 
	    	 StringBuilder input3 = new StringBuilder();
	    	 
	    	 input3.append(s3);
	    	 input3.reverse();
	    	 s3 = input3.toString();
	    }
	    
	    if(ord.equals("ABC"))
	    {
	    	r = s1 + s2 + s3;	
	    }
	    if(ord.equals("ACB"))
	    {
	    	r = s1 + s3 + s2;	
	    }
	    if(ord.equals("BAC"))
	    {
	    	r = s2 + s1 + s3;	
	    }
	    if(ord.equals("BCA"))
	    {
	    	r = s2 + s3 + s1;	
	    }
	    if(ord.equals("CAB"))
	    {
	    	r = s3 + s1 + s2;	
	    }
	    if(ord.equals("CBA"))
	    {
	    	r = s3 + s2 + s1;	
	    }
		response.setContentType("text/html"); // Tells the web container what we're sending back
		PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window
			out.println("<p>" + r + "</p>");
			out.println("<p>" + ord + "</p>");
		
	}
	
	

}
