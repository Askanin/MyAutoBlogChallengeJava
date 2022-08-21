package challenge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import challenge.model.Post;
import challenge.repository.PostRepository;
import challenge.security.IAuthenticationFacade;

@RestController
public class PostController {

	@Autowired
	private PostRepository repository;
	
	@Autowired
    IAuthenticationFacade authenticationFacade;
	
	@PostMapping("/posts")
	public Post newPost(@Valid @RequestBody Post post) {
		return repository.save(post);
	}
	
	@GetMapping("/posts")
	public Iterable<Post> listPost() {
		return repository.findAll();
	}
	
	@GetMapping("/post/{title}")
	public List<Post> getPostByTitle(@PathVariable("title") String title) {
		return repository.findByName(title);
	}
	
//	@DeleteMapping("/posts/{title}")
//	public void deletePost(@PathVariable("title") String nome) {
//		List<Post> var = repository.findByName(nome);
//		if()
//	}
}
