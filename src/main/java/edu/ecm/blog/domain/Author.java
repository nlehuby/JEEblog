package edu.ecm.blog.domain;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {
	@Column
	private String name;

	@Column
	private String email;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
