package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@author roman-rggeleta@dmacc.edu
 *CIS175-Spring 2022
 *Feb 24, 2022
 */
@Entity
@Table(name="author")
public class BookList {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="Author")
	private String author;
	
	public BookList() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public BookList(int id, String name, String author) {
		super();
		this.id = id;
		this.title = name;
		this.author = author;
	}


	public BookList(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
