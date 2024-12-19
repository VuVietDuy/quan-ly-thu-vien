package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.BorrowingDAO;

@WebServlet("/return-book")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReturnBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int borrowingDetailsId = Integer.parseInt(request.getParameter("borrowingDetailsId"));
		BorrowingDAO borrowingDAO = new BorrowingDAO();
		borrowingDAO.returnBook(borrowingDetailsId);
		response.sendRedirect(request.getContextPath() + "/borrowings");
	}

}
