package com.workshop.workshopmongo.config;

import com.workshop.workshopmongo.domains.Post;
import com.workshop.workshopmongo.domains.User;
import com.workshop.workshopmongo.dto.AuthorDTO;
import com.workshop.workshopmongo.repository.PostRepository;
import com.workshop.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        repository.deleteAll();
        postRepository.deleteAll();

        User p1 = new User(null,"Manel","maneldocapa@gmail.com");
        User p2 = new User(null,"sofia","maximos@gmail.com");
        User p3 = new User(null,"toquin","tutuca@gmail.com");

        repository.saveAll(Arrays.asList(p1,p2,p3));

        Post post1 = new Post(null,sdf.parse("11/11/2001"),"I love my job in the tower"," I work at two towers", new AuthorDTO(p1));
        Post post2 = new Post(null,sdf.parse("25/10/2022"),"Its My Birthdate","God bless me", new AuthorDTO(p2));

        postRepository.saveAll(Arrays.asList(post1,post2));



    }
}
