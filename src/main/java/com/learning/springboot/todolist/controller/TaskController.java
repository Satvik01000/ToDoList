package com.learning.springboot.todolist.controller;

import com.learning.springboot.todolist.DTO.AddTaskRequestDTO;
import com.learning.springboot.todolist.models.Task;
import com.learning.springboot.todolist.service.FakeToDoTaskService;
import com.learning.springboot.todolist.service.TaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TaskController {
    TaskService taskService=new FakeToDoTaskService(new RestTemplate());

    //Get a single Task by Task ID
    @GetMapping("/tasks/{id}")
    public Task getSingleTask(@PathVariable("id") Long taskId){
        return taskService.getSingleTask(taskId);
    }


    //Add a task
    @PostMapping("/tasks/add/")
    public Task addATask(@RequestBody AddTaskRequestDTO newTask){
        return taskService.addTask(newTask.getTodo(), newTask.getCompleted(), newTask.getUserId());
    }

    @PutMapping("/tasks/update/{id}")
    public Task updateATaskCompletely(@PathVariable Long id, @RequestBody AddTaskRequestDTO updateTask){
        return taskService.updateTaskCompletely(id, updateTask.getUserId(), updateTask.getTodo(), updateTask.getCompleted(), updateTask.getUserId());
    }
}
