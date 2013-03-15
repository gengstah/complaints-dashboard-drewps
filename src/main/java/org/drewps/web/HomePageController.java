package org.drewps.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.drewps.domain.Complaint;
import org.drewps.manager.ComplaintManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HomePageController implements Controller {
	private ComplaintManager complaintManager;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Complaint> openComplaints = complaintManager.getOpenComplaints();
		List<Complaint> closedComplaints = complaintManager.getClosedComplaints();
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("openComplaints", openComplaints);
		modelMap.put("closedComplaints", closedComplaints);
		
		return new ModelAndView("complaints", modelMap);
	}

	public void setComplaintManager(ComplaintManager complaintManager) {
		this.complaintManager = complaintManager;
	}
}