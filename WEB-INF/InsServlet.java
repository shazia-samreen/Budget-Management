import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class InsServlet extends HttpServlet
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
		ResultSet rs=st.executeQuery("select * from "+btablename);
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body{background:url(backg1.png);background-repeat:no-repeat;}");
		out.println("h3{padding:25px; margin:30px; text-align:center; font-size:30px;}");
		out.print(".b1{background-color:orange;text-align:center;font-size:22px;font-family:Georgia;font-style:bold;");
		out.print("width:160px;height:50px;border:none;border-radius:4px;transition:all 0.5s;cursor:pointer; }");
		out.print(".b2{background-color:lightgrey;text-align:center;font-size:18px;font-family:Georgia;font-style:bold;");
		out.print("width:160px;height:50px;border:none;border-radius:4px;transition:all 0.5s;cursor:pointer; }");
		out.print(".b2 span{cursor: pointer;display: inline-block;position: relative;transition: 0.5s; }");
		out.print(".b2 span:after{content:\">\";position: absolute;opacity: 0;top: 0;right: -20px;transition: 0.5s; }");
		out.print(".b2:hover span{padding-right:25px;}");
		out.print(".b2:hover span:after {opacity: 1;	right: 0;}");
		out.print("h2{font-family:Sitka Small;font-style:bold;font-size:52px;text-shadow: 4px 2px white;text-align:center;}");
		out.println("</style>");
		out.println("<script type=text/javascript>");
		out.println("function myadd(str,str1,str3,str4){");
		out.println("var node=document.createElement('div');");
		out.println("var node1=document.createElement(\"INPUT\");");
		out.println("node1.setAttribute(\"type\",\"text\");");
		out.println("var node2=document.createElement(\"INPUT\");");
		out.println("node2.setAttribute(\"type\",\"text\");");
		out.println("node.className=str3;");
		out.println("var u=document.getElementsByClassName(str)[0];");
		out.println("u.append(node);");
		out.println("var g1=u.getElementsByClassName(str1)[0];");
		out.println("g1.appendChild(node1);");
		out.println("g1.appendChild(node2);");
		out.println("node.appendChild(g1);");
		out.println("var x1=prompt(\"Enter Category name\");");
		out.println("var x2=prompt(\"Enter Category value\");");
		out.println("var m=u.getElementsByClassName(str3)[0];");
		out.println("var k=m.getElementsByClassName(str1)[0];");
		out.println("node1.setAttribute(\"value\",x1);");
		out.println("node2.setAttribute(\"value\",x2);");
		out.println("node1.setAttribute(\"name\",x1);");
		out.println("node2.setAttribute(\"name\",x2);");
		out.println("}");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=last.com method=post>");
		int i=1;
		out.println("<h2>Budget Categories</h2>");
		out.println("<h3>");
		while(rs.next())
			{
				String temp="adding"+i;
				String temp3="c"+i;
				String temp1="n"+i;
				String temp4="k"+i;
				String att=rs.getString(1);
				int val=rs.getInt(2);
				out.println("<div class="+temp+" style=\"float:left;height:170px; width:454px;\">");
				out.println("<input type=button class=b1 value="+att+"  onclick=myadd('"+temp+"','"+temp1+"','"+temp3+"','"+temp4+"')>");
				out.println("<div class="+temp1+">");
				out.println("</div>");
				out.println("</div>");
				out.println("<div class=p2 style=\"font-style:bold;text-shadow: 2px 1px lightgrey;text-align:left;float:right;height:170px;width:930px;\">");
				out.println("-->  Click Here to enter values belonging to "+att+" category");
				out.println("</div>");
				out.println("<br><br>");
				i=i+1;
			}
		out.println("<br>");
		out.println("<br>");
		out.println("<button class=b2 type=submit><span><b>Done</b></span></button>");
		out.println("</h3>");
		out.println("</form>");
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