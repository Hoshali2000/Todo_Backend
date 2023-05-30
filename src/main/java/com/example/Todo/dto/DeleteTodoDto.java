package com.example.Todo.dto;

import jakarta.validation.constraints.NotBlank;

public class DeleteTodoDto {
    @NotBlank(message = "id is required")
    public String id;
}
