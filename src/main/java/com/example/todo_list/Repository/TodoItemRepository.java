package com.example.todo_list.Repository;

import com.example.todo_list.Model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoItemRepository extends JpaRepository<TodoItem, UUID> {
}
