package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/QuoteAdminServlet")
public class QuoteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Integer addQA = 100;
    
    public QuoteAdminServlet() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Quote> quoteList = (List<Quote>) getServletContext().getAttribute("quoteList");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<body bgcolor = 'E9967A'>");
		out.println("<form action='QuoteAdminServlet' method='post'>");
		out.println("<table class= \"table table-bordered\">");
		out.println("<tr><th>Quote</th><th>Author</th><th>Remove Link</th></tr>");
		for(int i=0;i<quoteList.size();i++){
		out.println("<tr><td>"+quoteList.get(i).getDescription()+"</td>");
		out.println("<td>"+quoteList.get(i).getAuthor()+"</td>");
		out.println("<td><a href='RemoveQuote?id="+quoteList.get(i).getId()+"'>Remove</a></td></tr>");		}
		out.println("</table>");
		out.println("<p>Quote.:&nbsp&nbsp&nbsp<input type='text' name='quoteText' /></p>");
		out.println("<p>Author:&nbsp&nbsp&nbsp<input type='text' name='authorText' /></p>");
		out.println("<input type='submit' name='add' value='Add' />");
		out.println("<br><br>");
		out.println("<a href='QuoteServlet'>CLICK ON THE LINK TO SEE ALL THE QUOTES</a>");
		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String quote = request.getParameter("quoteText");
		String author = request.getParameter("authorText");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Quote> quoteList  = (List<Quote>) getServletContext().getAttribute("quoteList");
		if(quote!=null && author!=null && !quote.isEmpty() && !author.isEmpty()){
			quoteList.add(new Quote(addQA++,author, quote));
			response.sendRedirect("QuoteAdminServlet");
		}
		else{
			out.println("<p>FILL BOTH THE FIELDS TOO ENTER THE QUOTE</p>");
			doGet(request, response);
		}
	}

}
