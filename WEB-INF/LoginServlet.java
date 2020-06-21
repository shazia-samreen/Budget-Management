import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class LoginServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String email=req.getParameter("EMAIL");
		String pwd=req.getParameter("PWD");
		PrintWriter out=res.getWriter();
		Connection con=null;
		Statement st=null;
		String phno=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","manager");
			out.print("Connection Established..");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from Register");
			int found=0,crct=0;
			while(rs.next()){
				if(rs.getString(4).equals(email)){
					if(rs.getString(5).equals(pwd)){
					phno=rs.getString(3);
					crct=1;
					}
					found=1;
					break;	
				    }
			}
			if(found==0){
				out.println("<html>");
				out.println("<head>");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('New User Please register first');");
				out.println("</script>");
				out.println("</head>");
				out.println("</html>");
				RequestDispatcher rd=req.getRequestDispatcher("/register.html");
				rd.forward(req,res);
			}
			else{	
				if(crct==1){
				String t1name="u"+phno; 
				HttpSession session=req.getSession();  
				session.setAttribute("budgettablename",t1name);
				RequestDispatcher rd1=req.getRequestDispatcher("inside.com");
				rd1.forward(req,res);
				}
				else{
				out.println("<html>");
				out.println("<head>");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Enter the correct password');");
				out.println("</script>");
				out.println("</head>");
				out.println("</html>");
				RequestDispatcher rd2=req.getRequestDispatcher("/login.html");
				rd2.forward(req,res);
				}
			}
		}
		catch(Exception se){
			out.print("Oops!..Something went wrong");
			out.print(se);
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
