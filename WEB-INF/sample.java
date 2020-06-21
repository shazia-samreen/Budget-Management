import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import java.util.Enumeration;
public class sample extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		Statement st=null;
		Statement st1=null;
		Connection con=null;
		Enumeration en=req.getParameterNames();
		PrintWriter out=res.getWriter();
		int flag=0;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","manager");
		st=con.createStatement();
		HttpSession session=req.getSession();  
		String btablename=(String)session.getAttribute("budgettablename");
		while(en.hasMoreElements())
		{
			Object objOri=en.nextElement();
			String param=(String)objOri;
			String value=req.getParameter(param);
			st1=con.createStatement();
			Object objOri1=en.nextElement();
			String param1=(String)objOri1;
			String val=req.getParameter(param1);
			int value1=0;
			if(val!=""){
				value1=Integer.parseInt(val);
			st1.executeUpdate("insert into "+btablename+" values("+"'"+value+"'"+","+"'"+value1+"'"+")");
			}
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("inside.com");
		requestDispatcher.forward(req,res);
	}
	catch(Exception e){
	out.print(e);
	}
	finally{
	try{
	if(con!=null && st!=null){
		st.close();
		con.close();
	}
	}
	catch(Exception e){
	}
	}
			
	}
}