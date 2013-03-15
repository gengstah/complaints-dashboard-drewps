package org.drewps.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.drewps.dao.DataAccessObject;
import org.drewps.domain.Complaint;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HomePageController implements Controller {
	private DataAccessObject dao;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Complaint> complaints = dao.getEntities(Complaint.class);
		return new ModelAndView("home", "complaints", complaints);
	}

	public void setDao(DataAccessObject dao) {
		this.dao = dao;
	}
}