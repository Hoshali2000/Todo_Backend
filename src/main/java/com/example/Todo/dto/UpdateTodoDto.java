package com.example.Todo.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdateTodoDto {
    @NotBlank(message = "id is required")
    public String id;
    @NotBlank(message = "title is required")
    public String title;
    @NotBlank(message = "desc is required")
    public String desc;
}
