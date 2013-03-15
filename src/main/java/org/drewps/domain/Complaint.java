package org.drewps.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPLAINT")
public class Complaint implements Serializable {
	private static final long serialVersionUID = -2304871381375871581L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long ticketNo;
	private String client;
	private Date date;
	private String remarksAndAnalysis;
	private String responsibleTeam;
	private String status;
	private String rsagOwner;
	
	public Complaint() { }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(Long ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarksAndAnalysis() {
		return remarksAndAnalysis;
	}

	public void setRemarksAndAnalysis(String remarksAndAnalysis) {
		this.remarksAndAnalysis = remarksAndAnalysis;
	}

	public String getResponsibleTeam() {
		return responsibleTeam;
	}

	public void setResponsibleTeam(String responsibleTeam) {
		this.responsibleTeam = responsibleTeam;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRsagOwner() {
		return rsagOwner;
	}

	public void setRsagOwner(String rsagOwner) {
		this.rsagOwner = rsagOwner;
	}
}