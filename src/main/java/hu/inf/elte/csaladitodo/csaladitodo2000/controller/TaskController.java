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
@RequestMapping("/api/tasks")
class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Task> all() {
        return taskService.findAll();
    }

    // Melyik Taskot ("feladatot") vezeti a paraméterben adott illető.
    @RequestMapping("/lead/{name}")
    public List<Task> findLeadUserTasks(@PathVariable(value="name") String username){
        List<Task> lista = new ArrayList<>();
        for(Task t : taskService.findAll()){
            if (t.getLead().getName().equals(username)){
                lista.add(t);
            }
        }
        return lista;
    }

    // Mely feladatokon dolgozik a paraméterben kapott illető.
    @RequestMapping("/work/{workername}")
    public List<Task> findWorkUserTasks(@PathVariable(value="workername") String username){
        User user = null;
        for(User u : userService.findAll()){
            if(u.getName().equals(username)){
                user = u;
                break;
            }
        }
        return user.getTasksToDo();
    }

}
