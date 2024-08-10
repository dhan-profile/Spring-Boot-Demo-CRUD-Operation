package com.mypractice.DemoCrudOperation.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
	
//	@ManyToMany(cascade= {CascadeType.MERGE,CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="User_Role", 
	joinColumns			= @JoinColumn(name="userIdTable", referencedColumnName="id"), 
	inverseJoinColumns	= @JoinColumn(name="roleIdTable", referencedColumnName="id"))
	private Set<Role> role = new HashSet<Role>();
	
	public Users() {

	}

	public Users(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	
}
