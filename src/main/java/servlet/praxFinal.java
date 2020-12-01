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
		   out.println("A simple example that demonstrates how to operate with");
		   out.println("multiple submit buttons.");
		   out.println("</p>");
		   out.print  ("<form method=\"post\"");
		   //David: (4) changes  action's url to your own url using a relative path to the servlet.
		   //If left untouched, the operation buttons go to Prof. Offutt website, and
		   // if you provide an erroneous path you will see a 404 (Not Found) error.
		   //In the form action, you can specify an absolute or relative path to your URL
		   // and optionally the servlet that will respond to the action.
		   //However, the original line only works when your app is deployed
		   // and not when running locally (yourpage.com vs localhost:port).
		   // For simplicity, I used a relative path but it is strongly recommended
		   // to use absolute paths because they can cached by web servers and browsers
		   out.println(" action=\"/" + Servlet + "\">");
		   out.println("");
		   out.println(" <table>");
		   out.println("  <tr>");
		   out.println("   <td>First Value:");
		   out.println("   <td><input type=\"text\" name=\"LHS\" value=\"" + 0 + "\" size=5>");
		   out.println("  </tr>");
		   out.println("  <tr>");
		   out.println("   <td>Second Value:");
		   out.println("   <td><input type=\"text\" name=\"RHS\" value=\"" + 0 + "\" size=5>");
		   out.println("  </tr>");
		   out.println("  <tr>");
		   out.println("   <td>Third Value:");
		   out.println("   <td><input type=\"text\" name=\"RHS\" value=\"" + 0 + "\" size=6>");
		   out.println("  </tr>");
		   out.println(" </table>");
		   out.println(" <br>");
		   out.println(" <br>");
		   out.println(" <input type=\"submit\" value=\"" + "Add" + "\" name=\"Operation\">");
		   out.println(" <input type=\"submit\" value=\"" + "Sub" + "\" name=\"Operation\">");
		   // David: (3) adds multiplication button
		   out.println(" <input type=\"submit\" value=\"" + "Mult" + "\" name=\"Operation\">");
		   out.println(" <input type=\"reset\" value=\"Reset\" name=\"reset\">");
		   out.println("</form>");
		   out.println("");
		   out.println("</body>");
		
		
		
		
	}
	
	
	

}
