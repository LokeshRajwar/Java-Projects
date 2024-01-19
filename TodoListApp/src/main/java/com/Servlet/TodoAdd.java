package com.Servlet;

import java.io.IOException;


import com.DAO.TodoDao;
import com.DbConnect.DbConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddTodo")
public class TodoAdd extends HttpServlet {
	private static final long serialVersionUID = 7775800488655970349L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String task = req.getParameter("task");
		String status = req.getParameter("status");
		
		TodoDao dao = new TodoDao(DbConnect.getConn());
		Boolean flag = dao.addTodo(username, task, status);
		HttpSession session = req.getSession();
		if(flag) {
			session.setAttribute("SuccessMessage", "Task Added to Todo Successfully !!!");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("FailedMessage", "No Task Added to Todo !!!");
			resp.sendRedirect("index.jsp");
		}
	}
	
}