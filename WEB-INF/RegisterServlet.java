import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String name=req.getParameter("NAME");
		String age=req.getParameter("AGE");
		String phno=req.getParameter("PHNO");
		String email=req.getParameter("EMAIL");
		String pwd=req.getParameter("PWD");
		PrintWriter out=res.getWriter();
		Statement st=null,st1=null,st2=null;
		Connection con=null;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","manager");
		st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from register");
		int flag=0;
		res.setContentType("text/html");
		while(rs.next())
		{
			if(rs.getString(3).equals(phno) || rs.getString(4).equals(email))
			{
				flag=1;
			}
		}
		if(flag==0)
		{
			//int i=st.executeUpdate("insert into register values("+"'"+name+"'"+","+"'"+age+"'"+","+"'"+phno+"'"+","+"'"+email+"'"+","+"'"+pwd+"'"+")");
			int i=st.executeUpdate("insert into register(name,age,phno,email,pwd) values("+"'"+name+"'"+","+"'"+age+"'"+","+"'"+phno+"'"+","+"'"+email+"'"+","+"'"+pwd+"'"+")");
			String t1name="u"+phno; 
			HttpSession session=req.getSession();  
			session.setAttribute("budgettablename",t1name);
			st1=con.createStatement();
			st1.executeUpdate("create table "+t1name+"(categoryname varchar(30),amount number(10))");
			st2=con.createStatement();
			String trans=t1name+"t";
			st2.executeUpdate("create table "+trans+"(cat_name varchar(20),value number(10),reg_date varchar(10))");
			out.println("<html>");
			out.println("<head>");
			out.println("<style>");
			out.println("body{background-size:100% 100%; background-repeat:no-repeat; }");
			out.println(".edit {background-color: lightgrey;color: black;text-align: center;transition: all 0.5s;font-size:20px;cursor: pointer;width:220px;height:50px;font-family:\"Georgia\"; border:0; border-radius:8px;}");
			out.println(".edit span {cursor: pointer; display: inline-block; position: relative; transition: 0.5s;}");
			out.println(".edit span:after{content:\">\" ;position: absolute;opacity: 0;top: 0;right: -20px;transition: 0.5s;}");
			out.println(".edit:hover span:after {opacity: 1;right: 0;}");
			out.println(".edit:hover span{ padding-right:25px;}");
			out.println(".i1{padding-right:50px;}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body background=bg3.jpg text=black>");
			out.println("<form action=adate.com method=post>");
			out.println("<br><br><br>");
			out.println("<table align=center>"); 
			out.println("<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>"); 
			out.println("<tr>");
			out.println("<td align=center>");
		    out.println("<img class=\"i1\" src=\"start.jpg\" height=400 width=480></img>");
			out.println("</td>");out.println("</tr>");
			out.println("<tr>");
			out.println("<td>");
			out.println("<font face=Sitka Small size=25px style=\"text-shadow:4px 2px lightgrey;\">");
			out.println("<i> Let us manage our own budget..!</i></font>");
			out.println("</td");
			out.println("</tr>");
			out.println("<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>");
			out.println("<tr>");
			out.println("<td align=center>");
			out.println("<button align=center class=\"edit\"><span><b>Let's get started</b></span></button>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table"); 
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			//RequestDispatcher rd1=req.getRequestDispatcher("/budget.html");
			//rd1.forward(req,res);
		}
		else
			{
				out.println("<html>");
				out.println("<head>");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User already registered with phone number/email');");
				out.println("</script>");
				out.println("</head>");
				out.println("</html>");
				RequestDispatcher rd=req.getRequestDispatcher("/register.html");
				rd.include(req,res);
			}
		}
		catch(Exception e){
			out.print(e);
		}
		finally{
			try{
			if(con!=null && st!=null){
				con.close();
				st.close();
			}
			}
			catch(SQLException se){
				out.print(se);	
			}
		}
}
}
