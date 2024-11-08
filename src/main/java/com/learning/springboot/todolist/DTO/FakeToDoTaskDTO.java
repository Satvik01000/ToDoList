// src/main/java/com/learning/springboot/todolist/DTO/FakeToDoTaskDTO.java
package com.learning.springboot.todolist.DTO;

import com.learning.springboot.todolist.models.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeToDoTaskDTO {
    private Long id;
    private String todo;
    private Boolean completed;
    private Long userId;

    public Task toTask() {
        Task task = new Task();
        task.setTaskID(id);
        task.setWork(todo);
        task.setFinished(completed);
        task.setUserId(userId);
        return task;
    }
}