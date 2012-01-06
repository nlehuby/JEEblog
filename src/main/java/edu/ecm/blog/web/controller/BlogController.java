package edu.ecm.blog.web.controller;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import edu.ecm.blog.domain.Post;
import edu.ecm.blog.service.PostService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

	@Inject
	private PostService postService;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("posts", postService.find(0, 10));
		return "index";
	}

	@PostConstruct
	public void bootstrap() {
		if (postService.count() != 0) {
			//postService.clear();
			return;
		}
		Post post = new Post();
		post.setTitle("premier post");
		post.setSlug("premier-post");
		post.setDate(new Date());

		postService.save(post);

		post = new Post();
		post.setTitle("deuxième post");
		post.setSlug("deux-post");
		post.setDate(new Date());

		postService.save(post);

		post = new Post();
		post.setTitle("troisième post");
		post.setSlug("trois-post");
		post.setDate(new Date());

		postService.save(post);

	}
	
	@RequestMapping("/billet/{slug}")
	public String post(@PathVariable String slug, Model model) {
	    model.addAttribute("post", postService.findBySlug(slug));

	    return "post";
	}
}
