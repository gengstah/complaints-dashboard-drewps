package org.drewps.manager;

import java.util.List;

import org.drewps.domain.Complaint;

public interface ComplaintManager {
	Complaint addComplaint(Complaint complaint);
	Complaint updateComplaint(Complaint complaint);
	Complaint removeComplaint(Complaint complaint);
	Complaint reopenComplaint(Complaint complaint);
	List<Complaint> getOpenComplaints();
	List<Complaint> getClosedComplaints();
	Complaint findComplaint(Long id);
}