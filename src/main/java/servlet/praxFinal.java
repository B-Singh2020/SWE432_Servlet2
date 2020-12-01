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
		   out.println("   <td><input type=\"text\" name=\"LHS\" value=\"" + 0 + "\" size=5>");
		   out.println("  </tr>");
		   out.println("  <tr>");
		   out.println("   <td>Value B:");
		   out.println("   <td><input type=\"text\" name=\"RHS\" value=\"" + 0 + "\" size=5>");
		   out.println("  </tr>");
		   out.println("  <tr>");
		   out.println("   <td>Value C:");
		   out.println("   <td><input type=\"text\" name=\"RHS\" value=\"" + 0 + "\" size=6>");
		   out.println("  </tr>");
		   out.println("  <tr>");
		   out.println("   <td>Result:");
		   out.println("   <td><input type=\"text\" name=\"RHS\" value=\"" + 1 + "\" size=6>");
		   out.println("  </tr>");
		   out.println("  <tr>");
		   out.println("   <td>Order:");
		   out.println("   <td><input type=\"radio\" name=\"order\" value=\"" + "ABC" + "\"> ABC </input>");
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
	
	
	

}
