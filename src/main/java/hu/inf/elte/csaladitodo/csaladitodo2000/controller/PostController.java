package hu.inf.elte.csaladitodo.csaladitodo2000.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User;
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.PostService;


@RestController
@RequestMapping("/api/post")
class PostController {

    @Autowired
    private PostService userService;

    @GetMapping("/all")
    public List<User> all() {
        return userService.findAll();
    }

}
