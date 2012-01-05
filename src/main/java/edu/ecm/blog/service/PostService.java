package edu.ecm.blog.service;

import java.util.List;

import javax.inject.Inject;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.ecm.blog.domain.Post;

public class PostService {
	@Inject
	private SessionFactory sessionFactory;

	public void save(Post post) {
		Session session = sessionFactory.openSession();
		session.save(post);
		session.close();
	}

	public void delete(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Post where id=:id");
		query.setLong("id", id);
		query.executeUpdate();
		tx.commit();
		session.close();

	}

	public List find(int pageIndex, int pageSize) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Post.class);
		criteria.setFirstResult(pageIndex * pageSize);
		criteria.setMaxResults(pageSize);
		List posts = criteria.list();
		session.close();
		return posts;

	}

	public int count() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select count(*) from Post");
		Long i = (Long) query.uniqueResult();
		session.close();
		return i.intValue();
	}


}