package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/LifeCycleServlet")
public class ServletLifeCycleApp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Called when the servlet is first initialized
    @Override
    public void init() throws ServletException {
        System.out.println("init() method called - Servlet is initialized");
    }

    // Called for every request to the servlet
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        System.out.println("service() method called - Processing request");

        // Send response to client
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Demonstration of Servlet Life Cycle</h2>");
        out.println("<p>The <b>service()</b> method is handling this request.</p>");
        out.println("</body></html>");
    }

    // Called when the servlet is destroyed
    @Override
    public void destroy() {
        System.out.println("destroy() method called - Servlet is being destroyed");
    }
}
