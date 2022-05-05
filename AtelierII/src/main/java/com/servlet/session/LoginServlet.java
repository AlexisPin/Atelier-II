package com.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="LoginServlet" ,urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String surname = "admin";
    private final String password = "password";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String surname = request.getParameter("last-name");
        String password = request.getParameter("password");

        if (this.surname.equals(surname) && this.password.equals(password)) {
            //get the old session and invalidate
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //generate a new session
            HttpSession newSession = request.getSession(true);

            //setting session to expiry in 5 mins
            newSession.setMaxInactiveInterval(5*60);
            newSession.setAttribute("surname", surname);
            newSession.setAttribute("password", password);
            
            Cookie message = new Cookie("surname", surname);
            response.addCookie(message);
            response.sendRedirect("/card");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either username or password is wrong.</font>");
            rd.include(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String surname = request.getParameter("last-name");
        String password = request.getParameter("password");
        System.out.println("test");
        if(surname == null) surname = "";
        if(password == null) password = "";
        
        HttpSession session = request.getSession(true);
        session.setAttribute("surname", surname);
        session.setAttribute("password", password);
        
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
} 