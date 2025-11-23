package com.example.todo_list.Controller;

import com.example.todo_list.Model.TodoItem;
import com.example.todo_list.Service.TodoItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("todoItem")
public class TodoItemController implements GenericController {

    private final TodoItemService service;


    public TodoItemController(TodoItemService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Void> save (@RequestBody TodoItem todoItem){
        service.save(todoItem);
        URI location = generateHeaderLocation(todoItem.getId());
        return ResponseEntity.created(location).build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("{id}")
    public ResponseEntity<TodoItem> findById(@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        TodoItem todoItem = service.searchById(uuid);
        return ResponseEntity.ok(todoItem);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("{id}")
    public ResponseEntity<Void> update (@PathVariable("id") String id, @RequestBody TodoItem todoItem){

        UUID uuid = UUID.fromString(id);
        service.update(uuid, todoItem);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        service.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}
