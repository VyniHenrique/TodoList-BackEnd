package com.example.todo_list.Controller;

import com.example.todo_list.Model.TodoItem;
import com.example.todo_list.Service.TodoItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("todoItem")
public class TodoItemController implements GenericController {

    private final TodoItemService service;


    public TodoItemController(TodoItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> save (@RequestBody TodoItem todoItem){
        service.save(todoItem);
        URI location = generateHeaderLocation(todoItem.getId());
        return ResponseEntity.created(location).build();
    }
}
