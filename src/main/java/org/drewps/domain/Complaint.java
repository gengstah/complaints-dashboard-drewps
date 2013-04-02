package org.drewps.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COMPLAINT")
public class Complaint implements Serializable {
	private static final long serialVersionUID = -2304871381375871581L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Ticket # may not be null")
	private String ticketNo;
	private String client;
	private Date date;
	private String remarksAndAnalysis;
	private String responsibleTeam;
	private String status;
	private String rsagOwner;
	@Enumerated(EnumType.STRING)
	private FinalStatus finalStatus;
	
	public Complaint() { }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
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

	public FinalStatus getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(FinalStatus finalStatus) {
		this.finalStatus = finalStatus;
	}
	
	@Transient
	public int getDaysPassed() {
		long timeDifference = new Date().getTime() - date.getTime();
		
		return (int)(timeDifference / 1000 / 60 / 60 / 24);
	}
	
	@PrePersist
	public void prePersist() {
		finalStatus = FinalStatus.OPEN;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[id=").append(getId()).append(" | ");
		sb.append("ticketNo=").append(getTicketNo()).append(" | ");
		sb.append("client=").append(getClient()).append(" | ");
		sb.append("date=").append(getDate()).append(" | ");
		sb.append("remarksAndAnalysis=").append(getRemarksAndAnalysis()).append(" | ");
		sb.append("responsibleTeam=").append(getResponsibleTeam()).append(" | ");
		sb.append("status=").append(getStatus()).append(" | ");
		sb.append("rsagOwner=").append(getRsagOwner()).append(" | ");
		sb.append("finalStatus=").append(getFinalStatus()).append("]");
		
		return sb.toString();
	}
}