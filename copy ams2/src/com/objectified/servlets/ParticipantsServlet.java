/*package com.objectified.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.objectified.dao.BatchDBUtil;
import com.objectified.dto.User;
import com.objectified.model.UserBatchModel;

*//**
 * Servlet implementation class ParticipantsServlet
 *//*
@WebServlet("/ParticipantsServlet")
public class ParticipantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(ParticipantsServlet.class);
	BatchDBUtil dbutil = new BatchDBUtil();
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public ParticipantsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void addParticipant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		 PrintWriter out = response.getWriter(); 
		try {
			// response.setContentType("text/html");
			String u_Id, u_Batch, u_Role;
			u_Id = request.getParameter("userID");
			u_Batch = request.getParameter("batch_name");
			u_Role = request.getParameter("role");

			//System.out.println(".asdfsd.." + u_Id + " " + u_Batch + " " + u_Role);

			User user = dbutil.createUserBatch(u_Id, u_Batch, u_Role);
			if (user != null) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Participants.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			logger.error("Exception in Add Participant");
			e.printStackTrace();
		} finally {
			dbutil.closeEntityManagerFactory();
		}

	}

	protected void retriveParticipant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		 PrintWriter out = response.getWriter(); 
		try {
			String id = request.getParameter("batchID");
			List<UserBatchModel> userList = dbutil.retriveUser(id);

			Gson gson = new Gson();
			String json = gson.toJson(userList);
			response.setContentType("application/json");
			response.getWriter().write(json);

		} catch (Exception e) {
			logger.error("Exception in Retrive Participant");
			e.printStackTrace();
		} finally {
			dbutil.closeEntityManagerFactory();
		}

	}
}
*/