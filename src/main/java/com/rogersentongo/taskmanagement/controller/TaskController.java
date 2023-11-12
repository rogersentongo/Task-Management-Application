package com.rogersentongo.taskmanagement.controller;

import com.rogersentongo.taskmanagement.dto.TaskDto;
import com.rogersentongo.taskmanagement.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    //Build Add task Rest API
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto){
        TaskDto savedTask= taskService.addTask(taskDto);

        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);

    }

    //Build Get Task Rest API

    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER' )")
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long taskId){
        TaskDto taskDto=taskService.getTask(taskId);

        return new ResponseEntity<>(taskDto, HttpStatus.OK);

    }

    //Build Get All Tasks REST API
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER' )")
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> tasks =taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    //Build Update Task REST API
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto,@PathVariable("id") Long taskId){
        TaskDto updatedTask = taskService.updateTask(taskDto, taskId);

        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    //Build DELETE Task REST API
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId){
        taskService.deleteTask(taskId);

        return new ResponseEntity<>("Task deleted Successfully!", HttpStatus.OK);
    }

    //Build Complete Task Rest API
    @PatchMapping("{id}/complete")
    @PreAuthorize("hasAnyRole('ADMIN','USER' )")
    public ResponseEntity<TaskDto> completeTask(@PathVariable("id") Long taskId){
        TaskDto taskDto = taskService.completeTask(taskId);
        return ResponseEntity.ok(taskDto);
    }

    //Build inComplete Task REST API
    @PatchMapping("{id}/incomplete")
    @PreAuthorize("hasAnyRole('ADMIN','USER' )")
    public ResponseEntity<TaskDto> inCompleteTask(@PathVariable("id") Long taskId){
        TaskDto taskDto = taskService.inCompleteTask(taskId);
        return ResponseEntity.ok(taskDto);
    }


}
