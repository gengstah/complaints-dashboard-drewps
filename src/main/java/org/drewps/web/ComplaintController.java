package org.drewps.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.drewps.domain.Complaint;
import org.drewps.manager.ComplaintManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ComplaintController extends MultiActionController {
	private static final Logger log = Logger.getLogger(ComplaintController.class);
	private ComplaintManager complaintManager;
		
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response, Complaint complaint) {
		if(request.getMethod().toUpperCase().equals("POST")) {
			complaintManager.addComplaint(complaint);
			log.info("Complaint added");
			Map<String, Object> modelMap = createModelMap();
			
			return new ModelAndView("complaints", modelMap);
		}
		
		return new ModelAndView("complaintsform", "complaint", new Complaint());
	}
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response, Complaint complaint) {
		if(request.getMethod().toUpperCase().equals("POST")) {
			complaintManager.updateComplaint(complaint);
			log.info("Complaint updated");
			Map<String, Object> modelMap = createModelMap();
			
			return new ModelAndView("complaints", modelMap);
		}
		
		Long id = Long.parseLong(request.getParameter("id"));
		Complaint complaintObj = complaintManager.findComplaint(id);
		return new ModelAndView("complaintsform", "complaint", complaintObj);
	}
	
	public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, Complaint complaint) {
		complaintManager.removeComplaint(complaint);
		log.info("Complaint removed");
		Map<String, Object> modelMap = createModelMap();
		
		return new ModelAndView("complaints", modelMap);
	}

	private Map<String, Object> createModelMap() {
		List<Complaint> openComplaints = complaintManager.getOpenComplaints();
		List<Complaint> closedComplaints = complaintManager.getClosedComplaints();
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("openComplaints", openComplaints);
		modelMap.put("closedComplaints", closedComplaints);
		return modelMap;
	}

	public void setComplaintManager(ComplaintManager complaintManager) {
		this.complaintManager = complaintManager;
	}
}