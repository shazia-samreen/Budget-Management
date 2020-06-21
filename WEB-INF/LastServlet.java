import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 
import java.text.DateFormat;  
import java.text.SimpleDateFormat;


public class LastServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		Statement st=null;
		Statement st1=null;
		PrintWriter out=null;
		Connection con=null;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","manager");
		st=con.createStatement();
		out=res.getWriter();
		res.setContentType("text/html");
		Enumeration en=req.getParameterNames();
		java.util.Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
        String strDate = dateFormat.format(date); 
		HttpSession session=req.getSession();  
		String btablename=(String)session.getAttribute("budgettablename");
		String trans=btablename+"t";
		while(en.hasMoreElements())
			{
			 String[] arr=new String[2];
			 for(int i=0;i<2;i++)
				{
			Object objOri=en.nextElement();
			st1=con.createStatement();
			String param=(String)objOri;
			String value=req.getParameter(param);
			 arr[i]=value;
			}
			//out.println("Parameter value 1:"+arr[0]+"Parameter value 2:"+Integer.parseInt(arr[1])+"Date is"+strDate+"\n");
			st1.executeUpdate("insert into "+trans+" values("+"'"+arr[0]+"'"+","+Integer.parseInt(arr[1])+","+"'"+strDate+"'"+")");
		 }


		  ResultSet rs=st.executeQuery("select sum(value),reg_date from "+trans+" group by reg_date order by reg_date");
		 int i=0;
		  while(rs.next())
		 {

			 int val=rs.getInt(1);
			 String x=rs.getString(2);
			 out.println("<input type=hidden class=x1 value="+val+">");
			 out.println("<input type=hidden class=d1 value="+x+">");
			 i++;
		 }
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<style>");
		 out.print(".b1{background-color:lightgrey;text-align:center;font-size:18px;font-family:Georgia;font-style:bold;");
		out.print("width:250px;height:50px;border:none;border-radius:4px;transition:all 0.5s;cursor:pointer; }");
		out.print(".b1 span{cursor: pointer;display: inline-block;position: relative;transition: 0.5s; }");
		out.print(".b1 span:after{content:\">\";position: absolute;opacity: 0;top: 0;right: -20px;transition: 0.5s; }");
		out.print(".b1:hover span{padding-right:25px;}");
		out.print(".b1:hover span:after {opacity: 1;	right: 0;}");
		out.print(".b2{background-color:lightgrey;text-align:center;font-size:18px;font-family:Georgia;font-style:bold;");
		out.print("width:250px;height:50px;border:none;border-radius:4px;transition:all 0.5s;cursor:pointer; }");
		out.print(".b2 span{cursor: pointer;display: inline-block;position: relative;transition: 0.5s; }");
		out.print(".b2 span:after{content:\">\";position: absolute;opacity: 0;top: 0;right: -20px;transition: 0.5s; }");
		out.print(".b2:hover span{padding-right:25px;}");
		out.print(".b2:hover span:after {opacity: 1;	right: 0;}");
		 out.println("</style>");
		 out.println("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>");
		 out.println("<script type=text/javascript>");
		 out.println("google.charts.load('current', {'packages':['bar']});");
		 out.println("function drawChart() {");
		 out.println("var data = new google.visualization.DataTable();");
		 out.println("data.addColumn('string', 'Date');");
		 out.println("data.addColumn('string','Salary');");
		 out.println("var p=document.getElementsByClassName('b1')[0].id;");
		 out.println("var i;");
		 out.println("for(i=0;i<p;i++){");
		 out.println("  var m1=document.getElementsByClassName('x1')[i].value;");
		 out.println("  var m2=document.getElementsByClassName('d1')[i].value;");
		 out.println("var a=[];");
		 out.println("var x=m2;");
		 out.println("a.push(x);");
		 out.println("a.push(m1);");
		 out.println("data.addRow(a);");
		 out.println("}");
		 out.println("var options = {chart: { title: 'Budget Management',},bars: 'vertical' };");
		 out.println("var chart = new google.charts.Bar(document.getElementById('barchart_material'));");
		 out.println("chart.draw(data, google.charts.Bar.convertOptions(options));");
		 out.println("}");
		 out.println("function clicked() {");
		 out.println("google.charts.setOnLoadCallback(drawChart);}");
		 out.println("</script>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<div id=\"barchart_material\" style=\"float:left;border:black 2px solid;width: 1000px; height: 650px;\"></div>");
		 out.println("<br><br><br><br><br><br>");
		 out.println("<div align=center>");
		 out.println("<form action=trans.com method=post>");
		 out.println("<button class=b2><span><b>Show Transactions</b></span></button>");
		 out.println("</form>");
		 out.println("</div>");
		 out.println("<br><br><br><br><br><br><br><br><br>");
		 out.println("<div align=center>");
		 out.println("<button class=b1 id="+i+" onclick=clicked()><span><b>Show Graph</b></span></button>");
		 out.println("</div>");
		 out.println("</body>");
		 out.println("</html>");
			
		}
		
		catch(Exception e){
			out.print(e);
		}
		finally{
		try{
			if(con!=null && st!=null && st1!=null){
				con.close();
				st.close();
				st1.close();
				}
			}
			catch(SQLException se){
				out.print(se);	
			}
		}
	
	}
}
