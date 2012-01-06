package edu.ecm.blog.service;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ecm.blog.domain.Post;

@Service
public class PostServiceImpl implements PostService {
	@Inject
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ecm.blog.service.PostService#save(edu.ecm.blog.domain.Post)
	 */
	@Override
	@Transactional
	public void save(Post post) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(post);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ecm.blog.service.PostService#delete(java.lang.Long)
	 */
	@Override
	@Transactional
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Post where id=:id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ecm.blog.service.PostService#find(int, int)
	 */
	@Override
	@Transactional
	public List find(int pageIndex, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Post.class);
		criteria.setFirstResult(pageIndex * pageSize);
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc("date"));
		List posts = criteria.list();
		return posts;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ecm.blog.service.PostService#count()
	 */
	@Override
	@Transactional
	public int count() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from Post");
		Long i = (Long) query.uniqueResult();
		return i.intValue();
	}

	@Override
	@Transactional
	public Post findBySlug(String slug) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from Post where slug=:slug");
		query.setString("slug", slug);
		Post i = (Post) query.uniqueResult();
		return i;
	}
	@Override
	@Transactional
	public void clear() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("delete from Post");
		query.executeUpdate();

	}

	@Override
	@Transactional
	public Post findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from Post where id=:id");
		query.setLong("id", id);
		Post i = (Post) query.uniqueResult();
		return i;
	}

		
		

}