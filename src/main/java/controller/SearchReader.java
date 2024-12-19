package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Reader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.ReaderDAO;


@WebServlet("/SearchReader")
public class SearchReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SearchReader() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");

	    ReaderDAO  readerDAO = new ReaderDAO();
	    List<Reader> matchedReaders = readerDAO.find(query);

	    // Respond with JSON
	    response.setContentType("application/json");
	    PrintWriter out = response.getWriter();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
