package resources;

import domains.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        List<User> list = new ArrayList<>();
        User p1 = new User(null,"Manel","manel@gmail.com");
        User p2 = new User(null,"sofia","fosifa@gmail.com");
        list.addAll(Arrays.asList(p1,p2));
        return ResponseEntity.ok().body(list);
    }
}
