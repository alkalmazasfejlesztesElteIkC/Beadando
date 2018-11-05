package hu.inf.elte.csaladitodo.csaladitodo2000.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User;
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.TaskService;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.UserService;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.UserRepository;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
@RequestMapping("/api/users")
class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/all")
    public List<User> all() {
        return userService.findAll();
    }

    // Ki vezeti az adott feladatot ami kiírásra került.
    @GetMapping("/lead/{taskname}")
    public String findLeadTask(@PathVariable(value="taskname") String taskname){
        Task task = null;
        for(Task t : taskService.findAll()){
            if (t.getTaskname().equals(taskname)){
                task = t;
                break;
            }
        }
        return task.getLead().getName();
    }

    // Akik egy adott Taskon ("feladaton") dolgoznak.
    @GetMapping("/work/{taskname}")
    public List<String> findWorersOnTask(@PathVariable(value="taskname") String taskname){
        Task task = null;
        for(Task t : taskService.findAll()){
            if(t.getTaskname().equals(taskname)){
                task = t;
                break;
            }
        }
        List<User> userlist = task.getWorkers();
        List<String> stringUsers = new ArrayList<>();
        for(User u : userlist){
            stringUsers.add(u.getName());
        }
        return stringUsers;
    }

    // id alapjan töröl az userek közül
    @GetMapping("/delete/{id}")
    public ResponseEntity deleteUserbyName(@PathVariable Integer id) {
        List<User> users = userService.findAll();
        User user = null;
        for(User u : users){
            if( u.getId() == id){
                user = u;
                break;
            }
        }
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
    // id alapján modositas
    @PutMapping("/{id}")
    public ResponseEntity<User> put(@PathVariable Integer id,  @RequestBody User user){
        for(User u : userService.findAll()){
            if( u.getId() == id){
                user.setId(id);
                return ResponseEntity.ok(userRepository.save(user));
            }
        }
        return ResponseEntity.notFound().build();

    }

    //regisztracio
    @PostMapping("/register")
    public ResponseEntity<User> post(@RequestBody User user) {
        List<User> users = userService.findAll();
        for(User u : users){
            if( u.getId() == user.getId()){
                return ResponseEntity.badRequest().build();
            }
        }
        //user.setId(null);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setName(User.Role.ROLE_USER);
        return ResponseEntity.ok(userRepository.save(user));
    }


}
