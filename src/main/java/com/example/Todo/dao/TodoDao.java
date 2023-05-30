package com.example.Todo.dao;

import com.example.Todo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDao extends JpaRepository<Todo,String> {

}
