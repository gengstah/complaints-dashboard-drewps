package org.drewps.manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.drewps.dao.DataAccessObject;
import org.drewps.domain.Complaint;
import org.drewps.domain.FinalStatus;

public class ComplaintManagerImpl implements ComplaintManager {
	private final Logger log = Logger.getLogger(getClass());
	private DataAccessObject dao;
	
	@Override
	public Complaint addComplaint(Complaint complaint) {
		complaint = (Complaint) dao.add(complaint);
		log.info("ComplaintManagerImpl.addComplaint(Complaint) added Complaint " + complaint);
		return complaint;
	}

	@Override
	public Complaint updateComplaint(Complaint complaint) {
		complaint = (Complaint) dao.update(complaint);
		log.info("ComplaintManagerImpl.updateComplaint(Complaint) updated Complaint " + complaint);
		return complaint;
	}

	@Override
	public Complaint removeComplaint(Complaint complaint) {
		complaint.setFinalStatus(FinalStatus.CLOSED);
		complaint = updateComplaint(complaint);
		log.info("ComplaintManagerImpl.removeComplaint(Complaint) removed Complaint " + complaint);
		return complaint;
	}
	
	@Override
	public Complaint reopenComplaint(Complaint complaint) {
		complaint.setFinalStatus(FinalStatus.OPEN);
		complaint = updateComplaint(complaint);
		log.info("ComplaintManagerImpl.reopenComplaint(Complaint) reopened Complaint " + complaint);
		return complaint;
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
		Complaint c = dao.get(id, Complaint.class);
		log.info("ComplaintManagerImpl.findComplaint(Long) found Complaint " + c);
		return c;
	}

	public void setDao(DataAccessObject dao) {
		this.dao = dao;
	}
}