package com.learning.springboot.todolist.service;

import com.learning.springboot.todolist.models.Task;

public interface TaskService {
    public Task getSingleTask(Long taskId);

    public Task addTask(String todo, Boolean completed, Long userId);


    //Completely update a task
    Task updateTaskCompletely(Long taskId, Long id, String todo, Boolean completed, Long userId);
}
