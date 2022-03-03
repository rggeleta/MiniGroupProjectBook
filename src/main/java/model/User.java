package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@author roman-rggeleta@dmacc.edu
 *CIS175-Spring 2022
 *Feb 27, 2022
 */
@Entity
@Table (name = "users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "USERSID")
	private int userId;
	@Column(name = "USERNAME")
	private String userName;
 
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}


	public User(String userName) {
		super();
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
	
	

}
