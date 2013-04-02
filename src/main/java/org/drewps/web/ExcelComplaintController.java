package org.drewps.web;

import org.drewps.manager.ComplaintManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExcelComplaintController {
	private ComplaintManager complaintManager;
	
	public ExcelComplaintController() { }
	
	@RequestMapping(value = "/secured/admin/excel", method = { RequestMethod.GET, RequestMethod.POST })
	public String buildExcelView(Model model) {		
		model.addAttribute("openComplaints", complaintManager.getOpenComplaints());
		model.addAttribute("closedComplaints", complaintManager.getClosedComplaints());
		
		return "excelComplaint";
	}

	public void setComplaintManager(ComplaintManager complaintManager) {
		this.complaintManager = complaintManager;
	}
}