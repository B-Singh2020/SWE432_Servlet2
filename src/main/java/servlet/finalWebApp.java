package servlet;


import javax.servlet.*; // servlet library

import javax.servlet.http.*; // servlet library
import java.io.*;
import javax.servlet.annotation.WebServlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
		out.println("<style>");
		out.println("h1 {");
		out.println("text-align: center;");
		out.println("}");
		out.println(".content {");
	    out.println("max-width: 500px;");
		out.println("margin: auto;");
		out.println("}");
		out.println("</style>");
		
		 out.println("<body>");
		 
		   out.println("<h1>");
		   out.println("String List Sorter");
		   out.println("</h1>");
		   out.println("<div class=\"content\">");
		   out.print  ("<form method=\"post\"");
		   out.println(" action=\"/" + Servlet + "\">");
		   out.println("");
		   out.println(" <table>");
		   out.println("  <tr>");
		   out.println("   <td>List Items:");
		   out.println("   <td><input type=\"text\" name=\"FS\" value=\"" + "" + "\" size=30>");
		   out.println("  </tr>");
		   out.println(" <br>");
		   		 
		   out.println("  <tr>");
		   out.println("   <td>Order:");
		   out.println("   <td><input type=\"radio\" name=\"order\"  value=\"" + "Ascending Order" + "\"checked> Ascending Order </input>");
		   out.println("   <td><input type=\"radio\" name=\"order\" value=\"" + "Descending Order" + "\"> Descending Order </input>");
		   out.println("  </tr>");
		   out.println(" </table>");
		   out.println(" <br>");
		   out.println(" <br>");
		   out.println(" <input type=\"submit\"  value=\"" + "Sort" + "\" name=\"Operation\">");
		   out.println(" <input type=\"reset\" value=\"Reset\" name=\"reset\">");
		   out.println("</form>");
		   out.println("");
		   out.println("</div>");
		   out.println("</body>");
		
		
		
		
	}
	
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String list = request.getParameter("FS");
		String ord = request.getParameter("order");
		String[] splited = list.split("\\s+");
		ArrayList<String> list0 = new ArrayList<>(Arrays.asList(splited));
		ArrayList<String> list1 = new ArrayList<>();
		
		for(int i = 0; i < list0.size(); i++)
		{
			
			 if(!list1.contains(list0.get(i)))
			{
				list1.add(list0.get(i));
			}
			
		}
		
		for(int i = 0; i < list1.size(); i ++)
		{
			if( list1.get(i).equals("onLoad") ||list1.get(i).contains("<") || list1.get(i).contains(">") || 
					list1.get(i).contains("=") || list1.get(i).contains("(") || list1.get(i).contains(")") 
					|| list1.get(i).contains("/") || list1.get(i).contains("\\"))
			{
			 list1.remove(i);	
			}
		}
			
		if(ord.equals("Descending Order"))
		{	
			
			Collections.reverse(list1);
			list = list1.toString();
		}
		else
		{
			list = list1.toString();
		}
		
		response.setContentType("text/html"); // Tells the web container what we're sending back
		PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window
			out.println("<p>" + list + "</p>");
		
	}


}
