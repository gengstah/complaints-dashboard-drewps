package org.drewps.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents a Role in the application
 * (i.e., Administrator and User).
 * 
 * @author Gengstah
 *
 */
@Entity
@Table(name="ROLENAME")
public class Role implements Serializable {
	private static final long serialVersionUID = 6254761483988564734L;
	private String roleName;
	private String description;
	
	public Role() { }

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Id
	@Column(name="ROLENAME", nullable=false, length=20)
	public String getRoleName() {
		return roleName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="DESCRIPTION", nullable=false, length=200)
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Role Name: ").append(getRoleName());
		
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Role && ((Role)obj).getRoleName() == null && getRoleName() == null) {
			return true;
		}
		
		if(obj instanceof Role && ((Role)obj).getRoleName() != null && getRoleName() != null) {
			if(((Role)obj).getRoleName().equals(getRoleName())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 0;
		
		if(getRoleName() == null) {
			return hashCode;
		}
		
		for(int i = 0;i < getRoleName().length();i++) {
			hashCode = hashCode + getRoleName().charAt(i);
		}
		
		return hashCode * 13;	
	}
}