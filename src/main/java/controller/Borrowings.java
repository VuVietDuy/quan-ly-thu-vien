package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Borrowing;

import java.io.IOException;
import java.util.List;

import dao.BorrowingDAO;

@WebServlet("/borrowings")
public class Borrowings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Borrowings() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setAttribute("activePage", "borrowings");
		request.setAttribute("titlePage", "Quản lý phiếu mượn");
		
		BorrowingDAO borrowingDAO = new BorrowingDAO();
		List<Borrowing> borrowings = borrowingDAO.find();
		request.setAttribute("borrowings", borrowings);

		RequestDispatcher dispatcher = request.getRequestDispatcher("borrowings.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
