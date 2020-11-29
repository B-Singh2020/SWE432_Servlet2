package servlet;

import javax.servlet.*; // servlet library

import javax.servlet.http.*; // servlet library
import java.io.*;
import javax.servlet.annotation.WebServlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
// The @WebServletannotation is used to declare a servlet
//@WebServlet(name = "LPC", urlPatterns = {"/LPC"})
public class SecondServlet extends HttpServlet {

	
	public void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String[] val1;
		val1 = (String[]) request.getAttribute("value1");
		String[] v1 = (String[])request.getAttribute("value2");

		
		//response.setContentType("text/html");
		int varNums = v1.length;
		if (varNums == 1)
		{
			printOneVar(v1,response);
		}

		else if (varNums == 2)
		{
			boolean[] finalBools = calculateBooleans(varNums, v1,val1);
			printTwoVars(v1,val1,finalBools,response);
		}
		else if (varNums == 3)
		{
			boolean[] finalBools = calculateBooleans(varNums, v1,val1);
			printThreeVars(v1,val1,finalBools,response);
		}
		else if (varNums == 4)
		{
			boolean[] finalBools = calculateBooleans(varNums, v1,val1);
			printFourVars(v1,val1,finalBools,response);
		}
		else if (varNums == 5)
		{
			boolean[] finalBools = calculateBooleans(varNums, v1,val1);
			printFiveVars(v1,val1,finalBools,response);
		}

	}
	
	private void printFiveVars(String[] vals, String[] ops, boolean[] finalBools, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();	
		out.println("<html>\n"
				+ "<head>\n"
				+ "<style>\n"
				+ "table {\n"
				+ "  font-family: arial, sans-serif;\n"
				+ "  border-collapse: collapse;\n"
				+ "  width: 100%;\n"
				+ "}\n"
				+ "\n"
				+ "td, th {\n"
				+ "  border: 1px solid #dddddd;\n"
				+ "  text-align: left;\n"
				+ "  padding: 8px;\n"
				+ "}\n"
				+ "\n"
				+ "tr:nth-child(even) {\n"
				+ "  background-color: #dddddd;\n"
				+ "}\n"
				+ "tr:nth-child(odd) {\n"
				+ "  background-color: 	#FFFFFF;\n"
				+ "}\n"
				+ "</style>\n"
				+ "</head>\n"
				+ "<body style=\"background-color:#021d3b ; \">\n"
				+ "\n"
				+ "<h2 style=\"color:#FFFFFF\" >Logical Predicate Table</h2>\n"
				+ "\n"
				+ "<table>\n"
				+ "  <tr>\n"
				+ "    <th>" + vals[0]+"</th>\n"
				+ "    <th>" + vals[1]+"</th>\n"
				+ "    <th>" + vals[2]+"</th>\n"
				+ "    <th>" + vals[3]+"</th>\n"
				+ "    <th>" + vals[4]+"</th>\n"
				+ "    <th>" + vals[0]+" "+ops[0]+" "+vals[1]+" "+ops[1]+" "+vals[2]+" "+ops[2]+" "+vals[3]+" "+ops[3]+" "+vals[4]+"</th>\n"
				+ "  </tr>\n"			

				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[0]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[1]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[2]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[3]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[4]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[5]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[6]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[7]+"</td>\n"
				+ "  </tr>\n"	
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[8]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[9]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[10]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[11]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[12]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[13]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[14]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[15]+"</td>\n"
				+ "  </tr>\n"	
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[16]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[17]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[18]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[19]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[20]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[21]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[22]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[23]+"</td>\n"
				+ "  </tr>\n"	
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[24]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[25]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[26]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[27]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[28]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[29]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[30]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[31]+"</td>\n"
				+ "  </tr>\n"
				+ "</table>\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>\n"
				+ "");
	}

	private void printFourVars(String[] vals, String[] ops, boolean[] finalBools, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>\n"
				+ "<head>\n"
				+ "<style>\n"
				+ "table {\n"
				+ "  font-family: arial, sans-serif;\n"
				+ "  border-collapse: collapse;\n"
				+ "  width: 100%;\n"
				+ "}\n"
				+ "\n"
				+ "td, th {\n"
				+ "  border: 1px solid #dddddd;\n"
				+ "  text-align: left;\n"
				+ "  padding: 8px;\n"
				+ "}\n"
				+ "\n"
				+ "tr:nth-child(even) {\n"
				+ "  background-color: #dddddd;\n"
				+ "}\n"
				+ "tr:nth-child(odd) {\n"
				+ "  background-color: 	#FFFFFF;\n"
				+ "}\n"
				+ "</style>\n"
				+ "</head>\n"
				+ "<body style=\"background-color:#021d3b ; \">\n"
				+ "\n"
				+ "<h2 style=\"color:#FFFFFF\">Logical Predicate Table</h2>\n"
				+ "\n"
				+ "<table>\n"
				+ "  <tr>\n"
				+ "    <th>" + vals[0]+"</th>\n"
				+ "    <th>" + vals[1]+"</th>\n"
				+ "    <th>" + vals[2]+"</th>\n"
				+ "    <th>" + vals[3]+"</th>\n"
				+ "    <th>" + vals[0]+" "+ops[0]+" "+vals[1]+" "+ops[1]+" "+vals[2]+" "+ops[2]+" "+vals[3]+"</th>\n"
				+ "  </tr>\n"						
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[0]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[1]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[2]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[3]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[4]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[5]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[6]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[7]+"</td>\n"
				+ "  </tr>\n"	
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[8]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[9]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[10]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[11]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[12]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[13]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[14]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[15]+"</td>\n"
				+ "  </tr>\n"					
				+ "</table>\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>\n"
				+ "");
	}

	private void printThreeVars(String[] vals, String[] ops, boolean[] finalBools, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		out.println("<html>\n"
				+ "<head>\n"
				+ "<style>\n"
				+ "table {\n"
				+ "  font-family: arial, sans-serif;\n"
				+ "  border-collapse: collapse;\n"
				+ "  width: 100%;\n"
				+ "}\n"
				+ "\n"
				+ "td, th {\n"
				+ "  border: 1px solid #dddddd;\n"
				+ "  text-align: left;\n"
				+ "  padding: 8px;\n"
				+ "}\n"
				+ "\n"
				+ "tr:nth-child(even) {\n"
				+ "  background-color: #dddddd;\n"
				+ "}\n"
				+ "tr:nth-child(odd) {\n"
				+ "  background-color: 	#FFFFFF;\n"
				+ "}\n"
				+ "</style>\n"
				+ "</head>\n"
				+ "<body style=\"background-color:#021d3b ; \">\n"
				+ "\n"
				+ "<h2 style=\"color:#FFFFFF\">Logical Predicate Table</h2>\n"
				+ "\n"
				+ "<table>\n"
				+ "  <tr>\n"
				+ "    <th>" + vals[0]+"</th>\n"
				+ "    <th>" + vals[1]+"</th>\n"
				+ "    <th>" + vals[2]+"</th>\n"
				+ "    <th>" + vals[0]+" "+ops[0]+" "+vals[1]+" "+ops[1]+" "+vals[2]+"</th>\n"
				+ "  </tr>\n"			
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[0]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[1]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[2]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[3]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[4]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[5]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[6]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[7]+"</td>\n"
				+ "  </tr>\n"				
				+ "</table>\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>\n"
				+ "");
	}

	private boolean[] calculateBooleans(int varNums, String[] v1, String[] ops) {

		ArrayList<Boolean> bools = new ArrayList<Boolean>();
		boolean answer = false;


		int c;
		if (varNums ==2)
		{

			boolean [] boo = {true,true};
			for(int i = 1; i<=4;i++)
			{

				c=0;

				if (ops[0].equals("and") || ops[0].equals("AMPH"))
				{
					
					answer = boo[0] && boo[1];
				}
				else if (ops[0].equals("or") || ops[0].equals("bitOr"))
				{
					answer = boo[0] || boo[1];
				}
				else if (ops[0].equals("xor") || ops[0].equals("carrot"))
				{
					answer = boo[0] ^ boo[1];
				}

				if (i%1==0)
				{
					boo[1]=!boo[1];
				}
				if (i%2==0)
				{
					boo[0]=!boo[0];
				}

				bools.add(answer);
			}
			boolean []answers = new boolean[bools.size()];
			for (int i=0;i<bools.size();i++)
			{
				answers[i]=bools.get(i);
			}			return  answers;
		}
		if (varNums ==3)
		{

			boolean [] boo = {true,true,true};
			for(int i = 1; i<=8;i++)
			{

				c=0;
				while (c<ops.length)
				{

					if (c==0)
					{
						if (ops[0].equals("and") || ops[0].equals("AMPH"))
						{
							
							answer = boo[0] && boo[1];
						}
						else if (ops[0].equals("or") || ops[0].equals("bitOr"))
						{
							answer = boo[0] || boo[1];
						}
						else if (ops[0].equals("xor") || ops[0].equals("carrot"))
						{
							answer = boo[0] ^ boo[1];
						}


					}
					else
					{
						if (ops[c].equals("and") || ops[c].equals("AMPH"))
						{
							answer = answer && boo[c+1];
						}
						else if (ops[c].equals("or") || ops[c].equals("bitOr"))
						{
							answer = answer || boo[c+1];
						}
						else if (ops[c].equals("xor") || ops[c].equals("carrot"))
						{
							answer = answer ^ boo[c+1];
						}
					}
					c++;
				}
				if (i%1==0)
				{
					boo[2]=!boo[2];
				}
				if (i%2==0)
				{
					boo[1]=!boo[1];
				}
				if (i%4==0)
				{
					boo[0]=!boo[0];
				}

				bools.add(answer);
			}
			boolean []answers = new boolean[bools.size()];
			for (int i=0;i<bools.size();i++)
			{
				answers[i]=bools.get(i);
			}
			return  answers;
		}
		if (varNums ==4)
		{

			boolean [] boo = {true,true,true,true};
			for(int i = 1; i<=16;i++)
			{

				c=0;
				while (c<ops.length)
				{

					if (c==0)
					{
						if (ops[0].equals("and") || ops[0].equals("AMPH"))
						{
							
							answer = boo[0] && boo[1];
						}
						else if (ops[0].equals("or") || ops[0].equals("bitOr"))
						{
							answer = boo[0] || boo[1];
						}
						else if (ops[0].equals("xor") || ops[0].equals("carrot"))
						{
							answer = boo[0] ^ boo[1];
						}


					}
					else
					{
						if (ops[c].equals("and") || ops[c].equals("AMPH"))
						{
							answer = answer && boo[c+1];
						}
						else if (ops[c].equals("or") || ops[c].equals("bitOr"))
						{
							answer = answer || boo[c+1];
						}
						else if (ops[c].equals("xor") || ops[c].equals("carrot"))
						{
							answer = answer ^ boo[c+1];
						}
					}
					c++;
				}
				if (i%1==0)
				{
					boo[3]=!boo[3];
				}
				if (i%2==0)
				{
					boo[2]=!boo[2];
				}
				if (i%4==0)
				{
					boo[1]=!boo[1];
				}
				if (i%8==0)
				{
					boo[0]=!boo[0];
				}
				bools.add(answer);
			}
			boolean []answers = new boolean[bools.size()];
			for (int i=0;i<bools.size();i++)
			{
				answers[i]=bools.get(i);
			}
			return answers;
		}
		if (varNums ==5)
		{

			boolean [] boo = {true,true,true,true,true};
			for(int i = 1; i<=32;i++)
			{

				c=0;
				while (c<ops.length)
				{

					if (c==0)
					{
						if (ops[0].equals("and") || ops[0].equals("AMPH"))
						{
							
							answer = boo[0] && boo[1];
						}
						else if (ops[0].equals("or") || ops[0].equals("bitOr"))
						{
							answer = boo[0] || boo[1];
						}
						else if (ops[0].equals("xor") || ops[0].equals("carrot"))
						{
							answer = boo[0] ^ boo[1];
						}


					}
					else
					{
						if (ops[c].equals("and") || ops[c].equals("AMPH"))
						{
							answer = answer && boo[c+1];
						}
						else if (ops[c].equals("or") || ops[c].equals("bitOr"))
						{
							answer = answer || boo[c+1];
						}
						else if (ops[c].equals("xor") || ops[c].equals("carrot"))
						{
							answer = answer ^ boo[c+1];
						}
					}
					c++;
				}
				if (i%1==0)
				{
					boo[4]=!boo[4];
				}
				if (i%2==0)
				{
					boo[3]=!boo[3];
				}
				if (i%4==0)
				{
					boo[2]=!boo[2];
				}
				if (i%8==0)
				{
					boo[1]=!boo[1];
				}
				if (i%16==0)
				{
					boo[0]=!boo[0];
				}
				bools.add(answer);
			}
			boolean []answers = new boolean[bools.size()];
			for (int i=0;i<bools.size();i++)
			{
				answers[i]=bools.get(i);
			}
			return  answers;
		}
		return null;

	}

	private void printOneVar(String[] vals, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>\n"
				+ "<head>\n"
				+ "<style>\n"
				+ "table {\n"
				+ "  font-family: arial, sans-serif;\n"
				+ "  border-collapse: collapse;\n"
				+ "  width: 100%;\n"
				+ "}\n"
				+ "\n"
				+ "td, th {\n"
				+ "  border: 1px solid #dddddd;\n"
				+ "  text-align: left;\n"
				+ "  padding: 8px;\n"
				+ "}\n"
				+ "\n"
				+ "tr:nth-child(even) {\n"
				+ "  background-color: #dddddd;\n"
				+ "}\n"
				+ "tr:nth-child(odd) {\n"
				+ "  background-color: 	#FFFFFF;\n"
				+ "}\n"
				+ "</style>\n"
				+ "</head>\n"
				+ "<body style=\"background-color:#021d3b ; \">\n"
				+ "\n"
				+ "<h2 style=\"color:#FFFFFF\">Logical Predicate Table</h2>\n"
				+ "\n"
				+ "<table>\n"
				+ "  <tr>\n"
				+ "    <th>" + vals[0]+"</th>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"

				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "  </tr>\n"
				+ "  </tr>\n"
				+ "</table>\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>\n"
				+ "");
	}

	private void printTwoVars(String[] vals,String[] ops, boolean[] finalBools, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>\n"
				+ "<head>\n"
				+ "<style>\n"
				+ "table {\n"
				+ "  font-family: arial, sans-serif;\n"
				+ "  border-collapse: collapse;\n"
				+ "  width: 100%;\n"
				+ "}\n"
				+ "\n"
				+ "td, th {\n"
				+ "  border: 1px solid #dddddd;\n"
				+ "  text-align: left;\n"
				+ "  padding: 8px;\n"
				+ "}\n"
				+ "\n"
				+ "tr:nth-child(even) {\n"
				+ "  background-color: #dddddd;\n"
				+ "}\n"
				+ "tr:nth-child(odd) {\n"
				+ "  background-color: 	#FFFFFF;\n"
				+ "}\n"
				+ "</style>\n"
				+ "</head>\n"
				+ "<body style=\"background-color:#021d3b ; \">\n"
				+ "\n"
				+ "<h2 style=\"color:#FFFFFF\">Logical Predicate Table</h2>\n"
				+ "\n"
				+ "<table>\n"
				+ "  <tr>\n"
				+ "    <th>" + vals[0]+"</th>\n"
				+ "    <th>" + vals[1]+"</th>\n"
				+ "    <th>" + vals[0]+" "+ops[0]+" "+vals[1]+"</th>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[0]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>T</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[1]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>T</td>\n"
				+ "    <td>"+finalBools[2]+"</td>\n"
				+ "  </tr>\n"
				+ "  <tr>\n"
				+ "    <td>F</td>\n"
				+ "    <td>F</td>\n"
				+ "    <td>"+finalBools[3]+"</td>\n"
				+ "  </tr>\n"
				+ "</table>\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>\n"
				+ "");
	}

}
