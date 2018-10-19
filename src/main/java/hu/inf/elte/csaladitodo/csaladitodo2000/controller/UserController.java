package hu.inf.elte.csaladitodo.csaladitodo2000.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User;
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.TaskService;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.UserService;


@RestController
@RequestMapping("/api/users")
class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;


    @GetMapping("/all")
    public List<User> all() {
        return userService.findAll();
    }

    // Ki vezeti az adott feladatot ami kiírásra került.
    @RequestMapping("/lead/{taskname}")
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
    @RequestMapping("/work/{taskname}")
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


}
