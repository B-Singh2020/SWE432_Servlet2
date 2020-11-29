package servlet;
// Simple example servlet from slides
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
@WebServlet(name = "LPC", urlPatterns = {"/LPC"})
public class LogicalPredicateCalculator extends HttpServlet // Inheriting from HttpServlet makes this a servlet
{
	static String Domain = "swe432-servlet2.herokuapp.com/";
	static String Path = "/";
	static String Servlet = "LPC";
	static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";
	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html"); // Tells the web container what we're sending back
		PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window
		out.println("<head>\n" + 
				"  <title> Logical Predicate Calculator </title>\n" + 
				"  <font size=5; color=white> </font>\n" + 
				"\n" + 
				"  <!-- CSS STUFF -->\n" + 
				"  <style type=\"text/css\">\n" + 
				"    .center {\n" + 
				"      margin-left: auto;\n" + 
				"      margin-right: auto;\n" + 
				"      font-family: \"Arial\";\n" + 
				"    }\n" + 
				"\n" + 
				"    .error-text {\n" + 
				"      color: #ed4343;\n" + 
				"      margin: auto;\n" + 
				"      margin-left: 40px;\n" + 
				"    }\n" + 
				"\n" + 
				"  </style>\n" + 
				"\n" + 
				"\n" + 
				"  <!-- JAVASCRIPT STUFF -->\n" + 
				"  <script>\n" + 
				"    var recordedVariableNames = new Set();\n" + 
				"    var logicOps = new Array();\n" + 
				"    var variables = new Array();\n" + 
				"    var opCount = 0;\n" + 
				"    var varCount = 0;\n" + 
				"    var variableNameCount = 0;\n" + 
				"\n" + 
				"    function submitManager() {\n" + 
				"      var bt = document.getElementById('submit');\n" + 
				"      if (varCount > 0) {\n" + 
				"        bt.disabled = false;\n" + 
				"      } else {\n" + 
				"        bt.disabled = true;\n" + 
				"      }\n" + 
				"    }\n" + 
				"\n" + 
				"    function keyPressed() {\n" + 
				"      var key = event.keyCode || event.charCode || event.which;\n" + 
				"      return key;\n" + 
				"    }\n" + 
				"\n" + 
				"    function delRow(row) {\n" + 
				"      var deleteTimes = 0;\n" + 
				"      var i = row.parentNode.parentNode.rowIndex;\n" + 
				"      var selectedVariable = document.getElementById(\"var_T\").rows[i].cells[0].innerHTML;\n" + 
				"      var extractedText = selectedVariable.match(\"[>].\\+[<]\")[0];\n" + 
				"      extractedText = extractedText.substring(1, extractedText.length - 1);\n" + 
				"      console.log(extractedText);\n" + 
				"      recordedVariableNames.delete(extractedText);\n" + 
				"      document.getElementById(\"var_T\").deleteRow(i);\n" + 
				"      varCount = varCount - 1;\n" + 
				"      submitManager();\n" + 
				"      var index = i - 4;\n" + 
				"      var logic = document.getElementById(\"predicate_table\");\n" + 
				"      var title = logic.rows[0];\n" + 
				"      var predS = logic.rows[1];\n" + 
				"\n" + 
				"      if (index == 0) {\n" + 
				"        title.deleteCell(1);\n" + 
				"        predS.deleteCell(1);\n" + 
				"        try {\n" + 
				"          title.deleteCell(1);\n" + 
				"          predS.deleteCell(1);\n" + 
				"          \n" + 
				"        } catch (err) {}\n" + 
				"      }\n" + 
				"\n" + 
				"      if (index == 1) {\n" + 
				"        title.deleteCell(2);\n" + 
				"        title.deleteCell(2);\n" + 
				"        predS.deleteCell(2);\n" + 
				"        predS.deleteCell(2);\n" + 
				"        opCount--;\n" + 
				"      }\n" + 
				"\n" + 
				"      if (index == 2) {\n" + 
				"        title.deleteCell(4);\n" + 
				"        title.deleteCell(4);\n" + 
				"        predS.deleteCell(4);\n" + 
				"        predS.deleteCell(4);\n" + 
				"        opCount--;\n" + 
				"      }\n" + 
				"\n" + 
				"      if (index == 3) {\n" + 
				"        title.deleteCell(6);\n" + 
				"        title.deleteCell(6);\n" + 
				"        predS.deleteCell(6);\n" + 
				"        predS.deleteCell(6);\n" + 
				"        opCount--;\n" + 
				"      }\n" + 
				"\n" + 
				"      if (index == 4) {\n" + 
				"        title.deleteCell(8);\n" + 
				"        title.deleteCell(8);\n" + 
				"        predS.deleteCell(8);\n" + 
				"        predS.deleteCell(8);\n" + 
				"               opCount--;\n" + 
				"      }\n" + 
				"\n" + 
				"    }\n" + 
				"\n" + 
				"    function addRow() {\n" + 
				"      //add a row to the rows collection and get a reference to the newly added row\n" + 
				"\n" + 
				"      var value = document.getElementById(\"v1\").value;\n" + 
				"\n" + 
				"      //var oCell = newRow.insertCell(0);\n" + 
				"      if (varCount == 5) {\n" + 
				"        document.getElementById(\"varErrorMessage\").innerHTML = 'Too many variables! A max of 5 are allowed';\n" + 
				"        return;\n" + 
				"      }\n" + 
				"      if (recordedVariableNames.has(value)) {\n" + 
				"        //console.log(value);\n" + 
				"        document.getElementById(\"varErrorMessage\").innerHTML = 'Variable name \"' + value + '\" already exists. Please enter a unique variable name.';\n" + 
				"        return;\n" + 
				"      } else if (!value) {\n" + 
				"        document.getElementById(\"varErrorMessage\").innerHTML = 'Please enter a variable name!';\n" + 
				"        return;\n" + 
				"      } else {\n" + 
				"\n" + 
				"        recordedVariableNames.add(value);\n" + 
				"        document.getElementById(\"varErrorMessage\").innerHTML = ''\n" + 
				"        var newRow = document.getElementById(\"var_T\").insertRow(-1);\n" + 
				"\n" + 
				"        oCell = newRow.insertCell(0);\n" + 
				"        oCell2 = newRow.insertCell(0);\n" + 
				"        oCell2.innerHTML = \"<td><font color=\\\"White\\\">\" + value + \"</font></td>\";\n" + 
				"        oCell.innerHTML = \"<td><button type=\\\"button\\\" class=\\\"btn btn-primary\\\" onclick=\\\"delRow(this)\\\"> delete </button> </td>\"\n" + 
				"\n" + 
				"        var logic = document.getElementById(\"predicate_table\");\n" + 
				"        var row = logic.rows[0];\n" + 
				"        operator = row.insertCell(-1);\n" + 
				"        variable = row.insertCell(-1);\n" + 
				"        variableNameCount++;\n" + 
				"        varCount++;\n" + 
				"        if (varCount != 1) {\n" + 
				"          operator.innerHTML = \"<th><font color=\\\"White\\\">Operator </font></th>\";\n" + 
				"        }\n" + 
				"        variable.innerHTML = \"<th><font color=\\\"White\\\">Variable \" + \"</font></th>\";\n" + 
				"        row = logic.rows[1];\n" + 
				"        operator = row.insertCell(-1);\n" + 
				"        variable = row.insertCell(-1);\n" + 
				"\n" + 
				"        if (varCount != 1) {\n" + 
				"          operator.innerHTML = \"<td>  <select type=\\\"text\\\" name=\\\"ops1\" +  \"\\\" id=\\\"ops\" + opCount + \"\\\"> <option value=\\\"and\\\">and</option> <option value=\\\"or\\\">or</option><option value=\\\"xor\\\">xor</option><option value=\\\"------\\\" disabled>------</option><option value=\\\"AMPH\\\">&&</option><option value=\\\"bitOr\\\">||</option><option value=\\\"carrot\\\">^</option></select></td>\"\n" + 
				"       \n" + 
				"       }\n" + 
				"       \n" + 
				"        variable.innerHTML = \" <td width=\\\"24%\\\" colspan=\\\"3\\\"><input  name=\\\"v1\" +  \"\\\" id=\\\"v\" + variableNameCount + \"\\\" type=\\\"text\\\" size=\\\"5\\\" value = \" + value + \" readonly=\\\"readonly\\\" style=\\\"background-color:#8c8c8c;\\\"></td>;\"\n" + 
				"      }\n" + 
				"      document.getElementById(\"v1\").value = \"\";\n" + 
				"      submitManager();\n" + 
				"    }\n" + 
				"\n" + 
				
				"\n" + 
				"\n" + 
				"    function ClickMe() {\n" + 
				"      alert(\"This is for the 432 Assignment 5\");\n" + 
				"    }\n" + 
				"\n" + 
				"    function ColabSummary() {\n" + 
				"      alert(\"The entirety of this code was done while on a discord call with each other. We first revamped our entire doGet based on suggestions from Assignment 3. A lot of the creative ideas and implementation came from Bhupinder during this. He figured out the javascript functions as needed in order to get our code functional. Utkarsh contributed as well figuring out other javascript functions or formatting that fit with the overall design plan. We then moved onto doPost. Here, Utkarsh was mostly in charge. He figured out the main logic behind calculating the truth table, and came up with the idea of having a seperate print statement for each number of variables. Bhupinder assisted by checking for errors and making tweaks to get the code running better, as well as debugging it.\");\n" + 
				"    }\n" + 
				"\n" + 
				"  </script>\n" + 
				"</head>\n" + 
				"\n" + 
				"<body style=\"background-color:#021d3b ; text-decoration: none; text-align: center;\">\n" + 
				"  <h1 style=\"font-family:Arial; color:white;\"> SWE 432 Logical Predicate Creator</h1>\n" + 
				"  <p style=\"font-weight: bold; text-decoration:underline; color: white\"> By: Bhupinder Singh &amp; Utkarsh Agarwal </p>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" +
				"  <form class=\"form\" name=\"form1\" method=\"post\" >\n" + 
				"\n" + 
				"\n" + 
				"    <table id=\"var_T\" border=\"0\" cellpadding=\"2\" cellspacing=\"1\" width=\"60%\" class=\"center\">\n" + 
				"      <tr>\n" + 
				"        <td width=\"60%\" colspan=\"6\" >\n" + 
				"          <P align=\"center\">\n" + 
				"            <font color=\"#FFFFFF\" size=\"2\"><b>To calculate a truth table for a logical predicate, please enter up to 5 variables below</b></font>\n" + 
				"          </P>\n" + 
							
				"        </td>\n" + 
				"      </tr>\n" + 
				"      <tr>\n" + 
				"      <tr>\n" + 
				"        <td width=\"60%\" colspan=\"6\" >\n" + 
				"          <P align=\"center\">\n" + 
				"			 <font color=\"#FFFFFF\" size=\"2\"><b>Variables must not contain spaces or be longer than six characters </b></font> " +
				"          </P>\n" + 
							
				"        </td>\n" + 
				"      </tr>\n" + 
				"      <tr>\n" + 
				"        <td colspan=\"6\">&nbsp;</td>\n" + 
				"      </tr> <!-- extra space -->\n" + 
				"\n" + 
				"      <th width=\"12%\">\n" + 
				"        <font color=\"White\">\n" + 
				"          Variable\n" + 
				"        </font>\n" + 
				"      </th>\n" + 
				"\n" + 
				"      <tr>\n" + 
				"\n" + 
				"\n" + 
				"        <td width=\"24%\" colspan=\"3\"><input name=vars[] type=\"text\" id=\"v1\" size=\"20\" maxlength=\"6\" onKeyDown=\"javascript: var keycode = keyPressed(event); if(keycode==32){ return false; }\"></td>\n" + 
				"        <td><button type=\"button\" class=\"btn btn-primary\" onclick=\"addRow()\"> Add </button> </td>\n" + 
				"      </tr>\n" + 
				"\n" + 
				"\n" + 
				"    </table>\n" + 
				"    <p class=\"error-text\" id=\"varErrorMessage\"> </p>\n" + 
				"\n" + 
				"    <h1 style=\"font-family:Arial; color:white;\">Logical Predicate Statements</h1>\n" + 
				"\n" + 
				"\n" + 
				"    <table id=\"predicate_table\" border=\"0\" cellpadding=\"2\" cellspacing=\"1\" width=\"60%\" class=\"center\">\n" + 
				"      <tbody>\n" + 
				"        <tr>\n" + 
				"\n" + 
				"        </tr>\n" + 
				"\n" + 
				"        <tr>\n" + 
				"\n" + 
				"        </tr>\n" + 
				"\n" + 
				"      </tbody>\n" + 
				"    </table>\n" + 
				"    <p class=\"error-text\" id=\"varErrorMessage\"> </p>\n" + 
				      "<p>&nbsp;</p>" + 
				"    <input type=\"submit\" id=\"submit\"  disabled name=\"Inputted\">\n" + 
				"<button type=\"button\" class=\"btn btn-primary\" onclick=\"ColabSummary()\"> Collab Summary</button>"	+
				"  </form>\n" + 
				"\n" + 
				"\n" + 
				"</body>\n" +""
				);

		out.close();
	}  // end doGet()

	

	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String[] val1;
		val1 = request.getParameterValues("ops1");
		String[] v1 = request.getParameterValues("v1");

		
	    request.setAttribute("value1", val1);
	    request.setAttribute("value2", v1);
		response.setContentType("text/html");

	    try
	    {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("./Serve");
		dispatcher.forward(request,response);
	    }
	    catch(ServletException e)
	    {
	    	e.printStackTrace();
	    }
		
		

	}

}  
 
 
