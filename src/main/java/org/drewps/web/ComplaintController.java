package org.drewps.web;

import java.util.List;
import javax.validation.Valid;
import org.drewps.domain.Complaint;
import org.drewps.manager.ComplaintManager;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ComplaintController {
	private ComplaintManager complaintManager;
	private PropertyEditorRegistrar customPropertyEditorRegistrar;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		customPropertyEditorRegistrar.registerCustomEditors(binder);
	}
	
	@RequestMapping(value = "/secured/complaints", method = { RequestMethod.GET, RequestMethod.POST })
	public String displayComplaints(Model model) {
		addComplaintsToModel(model);
		
		return "complaints";
	}
	
	private void addComplaintsToModel(Model model) {
		List<Complaint> openComplaints = complaintManager.getOpenComplaints();
		List<Complaint> closedComplaints = complaintManager.getClosedComplaints();
		model.addAttribute("openComplaints", openComplaints);
		model.addAttribute("closedComplaints", closedComplaints);
	}
	
	@RequestMapping(value = "/secured/admin/complaint/new", method = RequestMethod.GET)
	public String displayNewComplaintForm(Model model) {
		model.addAttribute("complaint", new Complaint());
		return "complaintsform";
	}
	
	@RequestMapping(value = "/secured/admin/complaint/new", method = RequestMethod.POST)
	public String addComplaintForm(@Valid Complaint complaint, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("complaint", complaint);
			return "complaintsform";
		}
		
		complaintManager.addComplaint(complaint);
		return "redirect:/webapp/secured/complaints";
	}
	
	@RequestMapping(value = "/secured/admin/complaint/update/{id}", method = RequestMethod.GET)
	public String displayUpdateComplaintForm(@PathVariable Long id, Model model) {
		Complaint complaint = complaintManager.findComplaint(id);
		model.addAttribute("complaint", complaint);
		
		return "complaintsform";
	}
	
	@RequestMapping(value = "/secured/admin/complaint/update/{id}", method = RequestMethod.POST)
	public String updateComplaintForm(@Valid Complaint complaint, BindingResult result, Model model) {
		if(result.hasErrors())  {
			model.addAttribute("complaint", complaint);
			return "complaintsform";
		}
		
		complaintManager.updateComplaint(complaint);
		return "redirect:/webapp/secured/complaints";
	}
		
	@RequestMapping(value = "/secured/admin/complaint/remove/{id}", method = RequestMethod.GET)
	public String removeComplaintForm(@PathVariable Long id) {
		Complaint complaint = complaintManager.findComplaint(id);
		complaintManager.removeComplaint(complaint);
		
		return "redirect:/webapp/secured/complaints";
	}
	
	@RequestMapping(value = "/secured/admin/complaint/remove-permanent/{id}", method = RequestMethod.GET)
	public String removeComplaintFormPermanently(@PathVariable Long id) {
		Complaint complaint = complaintManager.findComplaint(id);
		complaintManager.removeComplaintPermanently(complaint);
		
		return "redirect:/webapp/secured/complaints";
	}
	
	@RequestMapping(value = "/secured/admin/complaint/reopen/{id}", method = RequestMethod.GET)
	public String reopenComplaintForm(@PathVariable Long id) {
		Complaint complaint = complaintManager.findComplaint(id);
		complaintManager.reopenComplaint(complaint);
		
		return "redirect:/webapp/secured/complaints";
	}

	public void setComplaintManager(ComplaintManager complaintManager) {
		this.complaintManager = complaintManager;
	}

	public void setCustomPropertyEditorRegistrar(
			PropertyEditorRegistrar customPropertyEditorRegistrar) {
		this.customPropertyEditorRegistrar = customPropertyEditorRegistrar;
	}
}