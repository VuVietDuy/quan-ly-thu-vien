package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.BookDAO;

@WebServlet("/delete-book")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteBook() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDAO = new BookDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		bookDAO.deleteBookById(id);
		response.sendRedirect(request.getContextPath() + "/books");
	}

}
