/*package com.objectified.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
*//**
 * Servlet implementation class Route
 *//*
@WebServlet("/Route")
public class Route extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Route.class);
	BatchServlet bs=new BatchServlet();
    ParticipantsServlet ps=new ParticipantsServlet();
	*//**
	 * @see HttpServlet#HttpServlet()
	 *//*
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		logger.debug("Servlet URL Path Received" + action);
		// System.out.println(action);

		try {
			if (action.equals("/batch")) {

				batch(request, response);
			}
			else if (action.contains("/participants")) {
				logger.debug("Servlet Add Participant");
				participant(request, response);
				// String a=request.getRequestURI();
				// System.out.println(a);
				// addParticipant(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/home.jsp");
				dispatcher.forward(request, response);
			}
		} catch (
		SQLException ex) {
			logger.error("Route Get Sql Exception");
			throw new ServletException(ex);
		}
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		logger.debug("Servlet Function Path Received" + action);
		try {
			switch (action) {

			case "/batch/fetch_batch":
				logger.debug("Servlet Fetch Batch");
				bs.listBatch(request, response);
				break;
			case "/batch/add_batch":
				logger.debug("Servlet Add Batch");
				bs.addBatch(request, response);
				break;
			case "/batch/delete_batch":
				logger.debug("Servlet Delete Batch");
				bs.deleteBatch(request, response);
				break;
			case "/batch/fetch_course":
				logger.debug("Servlet Fetch Course");
				bs.listCourse(request, response);
				break;
			case "/addParticipants":
				logger.debug("Servlet Add Participant");
				ps.addParticipant(request, response);
				break;
			case "/retriveParticipants":
				logger.debug("Servlet Retrive Participant");
				ps.retriveParticipant(request, response);
				break;
			}
		} catch (SQLException ex) {
			logger.error("Route Post Sql Exception");
			throw new ServletException(ex);
		}

	}

	private void batch(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/batch.jsp");
		dispatcher.forward(request, response);
	}

	private void participant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String a = request.getServletPath();
		System.out.println(a);
		request.setAttribute("course_name", a.substring(14));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/participants.jsp");
		dispatcher.forward(request, response);
	}
}
*/