import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class addDate extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	PrintWriter out=res.getWriter();
	res.setContentType("text/html");
	Date d=new Date();
	SimpleDateFormat sd=new SimpleDateFormat("YYYY-MM-dd");
	String s=sd.format(d);
	out.print("<html>");
	out.print("<head>");
	out.print("<style>");
	out.print("body{background:url(date.jpg);background-size:100% 100%;background-repeat:no-repeat;}");
	out.print("h1{font-size:55px;font-family:Sitka Small;text-shadow:6px 3px lightgrey;}");
	out.print("h2{font-size:35px;font-family:Georgia;text-shadow:2px 1px lightgrey;}");
	out.print(".b1{background-color:deepskyblue;text-align:center;font-size:18px;font-family:Georgia;font-style:bold;");
	out.print("width:120px;height:40px;border:none;border-radius:4px;transition:all 0.5s;cursor:pointer; }");
	out.print(".b1 span{cursor: pointer;display: inline-block;position: relative;transition: 0.5s; }");
	out.print(".b1 span:after{content:\">\";position: absolute;opacity: 0;top: 0;right: -20px;transition: 0.5s; }");
	out.print(".b1:hover span{padding-right:25px;}");
	out.print(".b1:hover span:after {opacity: 1;	right: 0;}");
	out.print("</style>");
	out.print("</head>");
	out.print("<body background=date.jpg align=center>");
	out.print("<form action=EntryPage.html>");
	out.print("<br><br><br><br>");
	out.print("<h1>New Budget</h1>");
	out.print("<h2>Enter Start Date:</h2><input type=date name=mindate min="+s+">");
	out.print("<h2>Enter End Date:</h2><input type=date name=maxdate min="+s+">");
	out.print("<br><br><br><br>");
	out.print("<button class=b1 type=submit><span><b>Submit</b></span></button>");
	out.print("</form>");
	out.print("</body>");
	out.print("</html>");
	}
}