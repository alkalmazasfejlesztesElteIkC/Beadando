package hu.inf.elte.csaladitodo.csaladitodo2000.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User;
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.TaskService;
import hu.inf.elte.csaladitodo.csaladitodo2000.service.UserService;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.TaskRepository;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
@RequestMapping("/api/tasks")
class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/all")
    public List<Task> all() {
        return taskService.findAll();
    }

    // Melyik Taskot ("feladatot") vezeti a paraméterben adott illető.
    @GetMapping("/lead/{name}")
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
    @GetMapping("/work/{workername}")
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

    // id alapján töröl feladatot
    @GetMapping("/delete/{id}")
    public List<Task> deleteTaskById(@PathVariable Integer id) {
        List<Task> tasks = taskService.findAll();
        Task task = null;
        for(Task t : tasks){
            if( t.getId() == id){
                task = t;
                break;
            }
        }
        taskRepository.delete(task);
        return taskService.findAll();
    }


    // id alapjan modosit
    @PutMapping("/{id}")
    public ResponseEntity<Task> put(@PathVariable Integer id,  @RequestBody Task task){
        for(Task t : taskService.findAll()){
            if( t.getId() == id){
                task.setId(id);
                return ResponseEntity.ok(taskRepository.save(task));
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/newTask")
    public ResponseEntity<Task> add(@RequestBody Task newTask){
        List<Task> tasks = taskService.findAll();
        for(Task t : tasks){
            if( t.getId() == newTask.getId()){
                return ResponseEntity.badRequest().build();
            }
        }
        //...
        return ResponseEntity.ok(taskRepository.save(newTask));
    }

}
