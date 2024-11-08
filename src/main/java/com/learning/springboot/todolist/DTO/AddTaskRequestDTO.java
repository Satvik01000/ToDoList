package com.learning.springboot.todolist.DTO;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class AddTaskRequestDTO {
    private String todo;
    private Boolean completed;
    private Long userId;
}
