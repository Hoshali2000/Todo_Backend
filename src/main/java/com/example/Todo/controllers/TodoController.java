package com.example.Todo.controllers;

import com.example.Todo.dto.CreateTodoDto;
import com.example.Todo.dto.DeleteTodoDto;
import com.example.Todo.dto.UpdateTodoDto;
import com.example.Todo.entities.Todo;
import com.example.Todo.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,Object> addTodo(@RequestBody @Valid CreateTodoDto body)
    {
        String result =todoService.add(body.title, body.desc);
        HashMap<String,Object>res=new HashMap<>();
        res.put("message",result);
        return res;
    }
    @DeleteMapping("/delete")
    public HashMap<String,Object> deleteTodo(@RequestBody @Valid DeleteTodoDto body)
    {
        String deleteRes=todoService.delete(body.id);
        HashMap<String,Object>response=new HashMap<>();
        response.put("message",deleteRes);
        return response;
    }
    @PutMapping("/update")
    public HashMap<String,Object> updateTodo(@RequestBody @Valid UpdateTodoDto body)
    {
        String updateRes=todoService.update(body.id, body.title, body.desc);
        HashMap<String,Object>response=new HashMap<>();
        response.put("message",updateRes);
        return response;
    }

    @GetMapping("/all")
    public HashMap<String,Object> getAll()
    {
        List<Todo> findRes=todoService.getAll();
        HashMap<String,Object>response=new HashMap<>();
        response.put("message","todos found");
        response.put("todos",findRes);
        return response;
    }

    @GetMapping("/{id}")
    public HashMap<String,Object> getById(@PathVariable("id") String id)
    {
        Todo findRes=todoService.getById(id);
        HashMap<String,Object>response=new HashMap<>();
        response.put("message","todo found");
        response.put("todo",findRes);
        return response;
    }


}
