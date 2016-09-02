package com.thursdayservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byethursday.Animal;
import com.byethursday.DAO;

/**
 * Servlet implementation class addToDB
 */
@WebServlet("/updateDB")
public class updateDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Animal addTodb = new Animal();
		
		addTodb.setspecies(request.getParameter("species"));
		addTodb.sethabitat(request.getParameter("habitat"));
		addTodb.setdiet(request.getParameter("diet"));
		addTodb.setactivity(request.getParameter("activity"));
		
		DAO.writeToDatabase(addTodb);
		
		request.getRequestDispatcher("index.html").forward(request, response);
		
	} //doPost

	
	
	
	
} //class