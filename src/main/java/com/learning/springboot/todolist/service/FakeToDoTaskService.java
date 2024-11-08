// src/main/java/com/learning/springboot/todolist/service/FakeToDoTaskService.java
package com.learning.springboot.todolist.service;

import com.learning.springboot.todolist.DTO.FakeToDoTaskDTO;
import com.learning.springboot.todolist.models.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeToDoTaskService implements TaskService {
    private final RestTemplate restTemplate;

    public FakeToDoTaskService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Get Single Task
    @Override
    public Task getSingleTask(Long taskId) {
        FakeToDoTaskDTO fakeToDoTaskDTO = restTemplate.getForObject(
                "https://dummyjson.com/todos/" + taskId,
                FakeToDoTaskDTO.class
        );
        assert fakeToDoTaskDTO != null;
        return fakeToDoTaskDTO.toTask();
    }

    //Add a Task
    @Override
    public Task addTask(String todo, Boolean completed, Long userId) {
        FakeToDoTaskDTO fakeToDoTaskDTO = new FakeToDoTaskDTO();
        fakeToDoTaskDTO.setTodo(todo);
        fakeToDoTaskDTO.setUserId(userId);
        fakeToDoTaskDTO.setCompleted(completed);

        FakeToDoTaskDTO response = restTemplate.postForObject(
                "https://dummyjson.com/todos/add",
                fakeToDoTaskDTO,
                FakeToDoTaskDTO.class
        );
        assert response != null;
        return response.toTask();
    }

    //Completely update a task
    @Override
    public Task updateTaskCompletely(Long taskId, Long id, String todo, Boolean completed, Long userId) {
        FakeToDoTaskDTO fakeToDoTaskDTO = new FakeToDoTaskDTO();
        fakeToDoTaskDTO.setCompleted(completed);
        fakeToDoTaskDTO.setUserId(userId);
        fakeToDoTaskDTO.setTodo(todo);

        FakeToDoTaskDTO response=restTemplate.patchForObject(
                "https://dummyjson.com/todos/" + taskId,
                fakeToDoTaskDTO,
                FakeToDoTaskDTO.class
        );
        assert response != null;
        return response.toTask();
    }

}