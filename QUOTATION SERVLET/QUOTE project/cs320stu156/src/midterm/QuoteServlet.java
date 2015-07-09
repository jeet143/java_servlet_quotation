package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList; //IMPORT FILES
import java.util.List;
//MADE BY ABHIJEET JOSHI
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/QuoteServlet", loadOnStartup=1) //URLL MAPPING
public class QuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Integer QuoteId;
	
   
    public QuoteServlet() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		List<Quote> quoteList = new ArrayList<Quote>();
		quoteList.add(new Quote(0, "ABHIJEET", "I AM WHAT I AM "));
		quoteList.add(new Quote(1, "THOMAS EDISON",   "YOUR FAILURE SHOWS THAT YOU ARE NEAR TO SUCCESS "));
		quoteList.add(new Quote(2, "GOOGLE", "QUOTE IS THE REPETITION OF ONE EXPRESSION "));
		quoteList.add(new Quote(3, "HRITHIK", "DARR KE AAGE JEET HAI"));
		getServletContext().setAttribute("quoteList", quoteList);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Quote> quoteList = (List<Quote>) getServletContext().getAttribute("quoteList");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><head><title>CS320 Midterm &#45 Quote Generator</title></head>");
		out.println("<body>");
		out.println("<body bgcolor = 'FFA500'>");
		out.println("<form action='QuoteServlet' method='post'>");//THE CODE WILL CALL THE POST METHOD IN THIS LINE
		int random = (int) (Math.random()*100%quoteList.size());
		out.println("<p> Quote: "+quoteList.get(random).getDescription()+"</p>");
		out.println("<p> Author: "+quoteList.get(random).getAuthor()+"</p>");
		out.println("<input type='submit' name='generate' value='NEW QUOTE PLEASE' />");
		out.println("<br><br>");
		out.println("<a href='QuoteAdminServlet'>Admin Quote Page</a>");
		out.println("</form></body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
