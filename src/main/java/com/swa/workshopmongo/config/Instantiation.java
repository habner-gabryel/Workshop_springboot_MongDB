package com.swa.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.swa.workshopmongo.domain.Post;
import com.swa.workshopmongo.domain.User;
import com.swa.workshopmongo.dto.AuthorDTO;
import com.swa.workshopmongo.repositories.PostRepository;
import com.swa.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		
		User u1 = new User(null, "Frantiesco Virgulini", "fiuuummm@gmail.com"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com"); 
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		postRepository.deleteAll();
		
		Post p1 = new Post(null, sdf.parse("21/03/2018") ,"Ban Dia", "uso òculos", new AuthorDTO(u1));
		Post p2 = new Post(null, sdf.parse("14/06/2020") ,"Olá marilene", "vinho, tainha e muita noite", new AuthorDTO(u1));
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		u1.getPosts().addAll(Arrays.asList(p1, p2));
		userRepository.save(u1);
		
	}

}
