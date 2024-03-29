package edu.ecm.blog.domain;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "post")
public class Post {
	@Column
	@NotEmpty
	private String title;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column
	private String slug;

	@ManyToOne(optional = true)
	private Author author;

	@Column(length = 4000)
	private String text;

	@Column
	private String tags;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}