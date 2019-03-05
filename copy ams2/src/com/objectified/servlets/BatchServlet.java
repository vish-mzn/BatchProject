package com.objectified.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.objectified.dao.BatchDaoImpl;
import com.objectified.dao.Connection;
import com.objectified.dto.Batch;
import com.objectified.dto.Course;
import com.objectified.model.BatchModel;
import com.objectified.model.CourseModel;
import com.objectified.service.BatchService;

@Controller
public class BatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbutil = new Connection();
	final static Logger logger = Logger.getLogger(BatchServlet.class);
	@Resource(name = "batchservice")
	private BatchService batchservice;

	@RequestMapping("/batch")
	public ModelAndView batch() {
		return new ModelAndView("batch");
	}

	@RequestMapping(value = "/batch/add_batch", method = RequestMethod.POST)
	protected ModelAndView addBatch(@RequestParam("batchNo") String batchNo, @RequestParam("courseId") String courseId,
			@RequestParam("date") String date, @RequestParam("week") String weeks) throws IOException {
		logger.debug("Add Batch Servlet Entered");

		String batchId = batchNo;
		int course = Integer.parseInt(courseId);

		int week = Integer.parseInt(weeks);
		String status = "active";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		
		 ApplicationContext ctx =new ClassPathXmlApplicationContext("META-INF/servlet-context.xml") ;//WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
				// ClassPathXmlApplicationContext("/WEB-INF/spring/appServlet/servlet-context.xml");
		 this.batchservice = (BatchService) ctx.getBean(BatchService.class);
		try {
			logger.debug("Add Batch Servlet Try block Entered");
			d = sdf.parse(date);
			Date actualDate = new Date(d.getTime());

			Batch batch = new Batch();
			Course co = new Course();
			co.setId(course);
			batch.setId(batchId);
			batch.setCourse(co);
			batch.setDate(actualDate);
			batch.setWeeks(week);
			batch.setStatus(status);
			this.batchservice.addBatch(batch);
			logger.debug("Add Batch Servlet Try block Ended");
		} catch (HibernateException e) {
			logger.error("Exception in Batch Add");
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error("ParseException in Batch Add");
			e.printStackTrace();
		} finally {
		
		}
		return new ModelAndView("redirect:/batch");
	}

	/*@RequestMapping(value = "/batch/fetch_batch", method = RequestMethod.POST)
	protected void listBatch(@RequestParam("pageid") int pageid, HttpServletRequest request,
			HttpServletResponse response,Model model) throws IOException {
		List<Object> batchlist = null;
		try {
			logger.debug("List Batch Servlet Try block Entered");
			int total = 5;
			if (pageid == 1) {
			} else {
				pageid = (pageid - 1) * total + 1;
			}
			float paginationsize = (float) (5 / total);
			if (paginationsize % 2 == 0) {
				paginationsize = paginationsize + 1;
			}
			batchlist = this.batchservice.listBatchs(pageid, total);
			batchlist.add(paginationsize);
			  model.addAttribute("batchlist",this.batchservice.listBatchs(pageid, total));
			String json = new Gson().toJson(batchlist);
			logger.debug("List Batch Servlet Try block Ended");
			response.setContentType("application/json");
			response.getWriter().write(json);

		} catch (HibernateException e) {
			logger.error("Exception in Batch list");
			e.printStackTrace();
		} finally {
			dbutil.closeEntityManagerFactory();
		}
	}*/

	@RequestMapping(value = "/batch/fetch_course", method = RequestMethod.POST)
	protected void listCourse(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			logger.debug("List Course Servlet Try block Entered...");
			List<Object> courseList = this.batchservice.listCourse();
			String json = new Gson().toJson(courseList);
			res.setContentType("application/json");
			res.getWriter().write(json);
			logger.debug("List Course Servlet Try block Ended");

		} catch (HibernateException e) {
			logger.error("Exception in Cousre list");
			e.printStackTrace();
		} finally {
			dbutil.closeEntityManagerFactory();
		}
	}

	/*
	 * protected void deleteBatch(HttpServletRequest request,
	 * HttpServletResponse response) throws SQLException, IOException,
	 * ServletException { BatchDBUtil dbutil = new BatchDBUtil();
	 * 
	 * try { logger.debug("Delete Batch Servlet Try block Entered"); String
	 * all[] = request.getParameterValues("all_checked[]"); for (String x : all)
	 * { dbutil.deleteBatch(x); } String json = "success";
	 * response.setContentType("application/json");
	 * logger.debug("Delete Batch Servlet Try block Ended");
	 * response.getWriter().write(json); } catch (ClassNotFoundException |
	 * SQLException e) { logger.error("Exception in Batch delete");
	 * e.printStackTrace(); } finally { dbutil.closeEntityManagerFactory(); } }
	 */
}
