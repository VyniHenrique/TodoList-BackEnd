package com.example.todo_list.Service;

import com.example.todo_list.Model.TodoItem;
import com.example.todo_list.Repository.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoItemService {
    private final TodoItemRepository todoItemRepository;

    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public void save(TodoItem todoItem){
        todoItemRepository.save(todoItem);
    }

    public TodoItem searchById(UUID id){

        Optional<TodoItem> optionalTodoItem = todoItemRepository.findById(id);
        if (optionalTodoItem.isPresent()){
            TodoItem todoItem = optionalTodoItem.get();
            todoItemRepository.save(todoItem);
            return todoItem;
        }
        return null;
    }

    public void update(UUID id, TodoItem todoItem){
        Optional<TodoItem> optionalTodoItem = todoItemRepository.findById(id);


        if (optionalTodoItem.isPresent()){
            TodoItem todoItemUpdated = optionalTodoItem.get();
            todoItemUpdated.setTitle(todoItem.getTitle());
            todoItemUpdated.setDescription(todoItem.getDescription());
            todoItemUpdated.setTimeLimit(todoItem.getTimeLimit());

            todoItemRepository.save(todoItemUpdated);
        }
    }

    public void deleteById(UUID id){
        todoItemRepository.deleteById(id);
    }

    public List<TodoItem> findAllTodoItem(){
        return todoItemRepository.findAll();
    }
}
