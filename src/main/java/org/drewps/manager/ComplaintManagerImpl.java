package org.drewps.manager;

import java.util.List;

import org.drewps.dao.DataAccessObject;
import org.drewps.domain.Complaint;
import org.drewps.domain.FinalStatus;

public class ComplaintManagerImpl implements ComplaintManager {
	private DataAccessObject dao;
	
	@Override
	public Complaint addComplaint(Complaint complaint) {
		return (Complaint) dao.add(complaint);
	}

	@Override
	public Complaint updateComplaint(Complaint complaint) {
		return (Complaint) dao.update(complaint);
	}

	@Override
	public Complaint removeComplaint(Complaint complaint) {
		complaint.setFinalStatus(FinalStatus.CLOSED);
		return updateComplaint(complaint);
	}

	@Override
	public List<Complaint> getOpenComplaints() {
		return dao.listOpenComplaints(Complaint.class);
	}

	@Override
	public List<Complaint> getClosedComplaints() {
		return dao.listClosedComplaints(Complaint.class);
	}
	
	@Override
	public Complaint findComplaint(Long id) {
		return dao.get(id, Complaint.class);
	}

	public void setDao(DataAccessObject dao) {
		this.dao = dao;
	}
}