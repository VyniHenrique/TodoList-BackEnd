package com.example.todo_list.Service;

import com.example.todo_list.Model.TodoItem;
import com.example.todo_list.Repository.TodoItemRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoItemService {
    private final TodoItemRepository todoItemRepository;

    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public TodoItem save(TodoItem todoItem){
        return todoItemRepository.save(todoItem);
    }
}
