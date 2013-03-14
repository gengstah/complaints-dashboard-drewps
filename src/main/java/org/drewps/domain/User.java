package org.drewps.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.catalina.realm.RealmBase;

@Entity
@Table(name="USER")
public class User implements Serializable {
	private static final long serialVersionUID = -3045716097358622386L;
	private String name;
	private String username;
	private String password;
	private String description;
	private List<Role> roles;
	
	public User() { }

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="NAME", nullable=false, length=50)
	public String getName() {
		return name;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Id
	@Column(name="USERNAME", nullable=false, length=20)
	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = RealmBase.Digest(password, "MD5", "ISO-8859-1");
	}

	@Column(name="PASSWORD", nullable=false, length=32)
	public String getPassword() {
		return password;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="DESCRIPTION", nullable=false, length=200)
	public String getDescription() {
		return description;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@ManyToMany
	@JoinTable(name = "USER_ROLENAME", joinColumns = { @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME") }, inverseJoinColumns = { @JoinColumn(name = "ROLENAME", referencedColumnName = "ROLENAME") })
	public List<Role> getRoles() {
		return roles;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ").append(getName()).append("\t")
			.append("Username: ").append(getUsername()).append("\t")
			.append("Password: ").append(getPassword());
		
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User && ((User) obj).getUsername() == null && getUsername() == null) {
			return true;
		}
		
		if(obj instanceof User && ((User) obj).getUsername() != null) {
			if (((User) obj).getUsername().equals(getUsername())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 0;
		
		if(getUsername() == null) {
			return hashCode;
		}
		
		for(int i = 0;i < getUsername().length();i++) {
			hashCode = hashCode + getUsername().charAt(i);
		}
		
		return hashCode * 13;	
	}
}