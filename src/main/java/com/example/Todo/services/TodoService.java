package com.example.Todo.services;

import com.example.Todo.dao.TodoDao;
import com.example.Todo.entities.Todo;
import com.example.Todo.exceptions.TodoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoDao todoDao;
    public String add(String title,String desc)
    {
        Todo todo=new Todo(title,desc);
        todoDao.save(todo);
        return "todo successfully created";
    }
    public String delete(String id)
    {
        Optional<Todo> todo= todoDao.findById(id);
        if (todo.isPresent()) {
            todoDao.delete(todo.get());
            return "todo deleted successfully";
        }
        else{
            throw new TodoNotFoundException("id not found");
        }
    }
    public String update(String id,String title,String desc)
    {
        Optional<Todo> todo= todoDao.findById(id);
        if(!todo.isPresent()) throw new TodoNotFoundException("id not found");
        Todo t=todo.get();
        t.setTitle(title);
        t.setDescription(desc);
        todoDao.save(t);
        return "todo updated successfully";

    }

    public List<Todo> getAll()
    {
        List<Todo> todos= todoDao.findAll();
        if(todos.size()==0)throw new TodoNotFoundException("no Todos found");
        return todos;
    }
    public Todo getById(String id)
    {
        Optional<Todo>todo= todoDao.findById(id);
        if(!todo.isPresent())throw new TodoNotFoundException("id not found");
        return todo.get();
    }

}
