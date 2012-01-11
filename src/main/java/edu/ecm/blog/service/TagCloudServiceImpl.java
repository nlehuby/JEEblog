package edu.ecm.blog.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ecm.blog.domain.Post;
import edu.ecm.blog.util.TagCloud;

@Service
public class TagCloudServiceImpl implements TagCloudService {
	@Inject
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public TagCloud buildTagCloud() {
		Session session = sessionFactory.getCurrentSession();

		TagCloud nuage = new TagCloud();

		Criteria criteria = session.createCriteria(Post.class);
		List<Post> liste_post = criteria.list();
		
		for (Post post : liste_post) {
			nuage.add(StringUtils.split(post.getTags(), ","));
		}

		return nuage;
	}

}