package edu.ecm.blog.service;

import java.util.List;

import edu.ecm.blog.domain.Post;

public interface PostService {

	public void save(Post post);

	public void delete(Long id);

	public List find(int pageIndex, int pageSize);

	public int count();

	public Post findBySlug(String slug);

	public void clear();

	public Post findById(Long id);
}