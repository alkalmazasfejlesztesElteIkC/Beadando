package hu.inf.elte.csaladitodo.csaladitodo2000.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;
import hu.inf.elte.csaladitodo.csaladitodo2000.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

	
}
