import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class TransServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		Statement st=null;
		Connection con=null;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","manager");
		st=con.createStatement();
		HttpSession session=req.getSession();  
		String btablename=(String)session.getAttribute("budgettablename");
		String trans=btablename+"t";
		ResultSet rs=st.executeQuery("select * from "+trans+" order by reg_date");
		ResultSetMetaData rsmd=rs.getMetaData();
		int nc=rsmd.getColumnCount();
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body{background:url(backg6.jpg);background-size:100% 100%;background-repeat:no-repeat;}");
		out.println("h2{color:yellow;font-family:Sitka Small;font-style:bold;font-size:52px;text-shadow:4px 2px black;text-align:center;}");
		out.println("table{border: 3px solid white;}");
		out.println("tr,td{border: 1px solid white;padding:10px;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Earlier Transactions</h2>");
		out.println("<hr>");
		out.println("<br><br><br>");
		out.println("<table align=center>");
		out.println("<tr>");
				out.println("<td align=center style=\"text-shadow: 2px 1px black;color:white;font-size:24px;font-style:bold;font-family:Georgia;height:38px;width:250px;\">"+rsmd.getColumnName(1)+"</td>");
				out.println("<td align=center style=\"text-shadow: 2px 1px black;color:white;font-size:24px;font-style:bold;font-family:Georgia;height:38px;width:150px;\">"+rsmd.getColumnName(2)+"</td>");
				out.println("<td align=center style=\"text-shadow: 2px 1px black;color:white;font-size:24px;font-style:bold;font-family:Georgia;height:38px;width:180px;\">"+rsmd.getColumnName(3)+"</td>");
		out.println("</tr>");
		while(rs.next())
			{
			out.println("<tr>");
				out.println("<td align=center style=\"text-shadow: 2px 1px black;color:white;font-size:24px;font-style:bold;font-family:Georgia;height:38px;width:250px;\">"+rs.getString(1)+"</td>");
				out.println("<td align=center style=\"text-shadow: 2px 1px black;color:white;font-size:24px;font-style:bold;font-family:Georgia;height:38px;width:150px;\">"+rs.getString(2)+"</td>");
				out.println("<td align=center style=\"text-shadow: 2px 1px black;color:white;font-size:24px;font-style:bold;font-family:Georgia;height:38px;width:180px;\">"+rs.getString(3)+"</td>");
			out.println("</tr>");
			}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
		try{
			if(con!=null && st!=null){
				con.close();
				st.close();
				}
			}
			catch(SQLException se){
				System.out.println(se);	
			}
		}
	
	}
}
