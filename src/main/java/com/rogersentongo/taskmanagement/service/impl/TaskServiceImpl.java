package com.rogersentongo.taskmanagement.service.impl;

import com.rogersentongo.taskmanagement.dto.TaskDto;
import com.rogersentongo.taskmanagement.entity.Task;
import com.rogersentongo.taskmanagement.exception.ResourceNotFoundException;
import com.rogersentongo.taskmanagement.repository.TaskRepository;
import com.rogersentongo.taskmanagement.service.TaskService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private ModelMapper modelMapper;

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        //convert TaskDto into Task Jpa entity using model mapper
        Task task = modelMapper.map(taskDto, Task.class);

        //Save Task jpa entity
        Task savedTask= taskRepository.save(task);

        //Convert saved task jpa to dto
        TaskDto savedTaskDto = modelMapper.map(savedTask,TaskDto.class);

        return savedTaskDto;
    }

    @Override
    public TaskDto getTask(Long id) {
        Task taskObj = taskRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Task not found with id:" +id)
        );

        //Convert taskObj to taskDto
        return modelMapper.map(taskObj,TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        //we get them into a list of Tasks
        List<Task> tasks = taskRepository.findAll();

        //we convert each into taskDto
        List<TaskDto> taskDtos = new ArrayList<>();
        for(Task tk: tasks){
            taskDtos.add(modelMapper.map(tk, TaskDto.class));
        }

        return taskDtos;
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto, Long id) {
        //we get the existing task
        Task task = taskRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Task not found with id:"+id)
        );

        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.isCompleted());

        //we save this object into the database
        Task updatedTask =taskRepository.save(task);//Automatically does update because we kept same id

        return modelMapper.map(updatedTask, TaskDto.class);



    }

    @Override
    public void deleteTask(Long id) {
        Task task =taskRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Task not found with id:"+id)
        );

        //we now delete the task
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDto completeTask(Long id) {
        //We need to check if it exists
        Task task =taskRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Task not found with id:"+id)
        );

        //we change its value to completed
        task.setCompleted(Boolean.TRUE);
        //we save it
        Task updatedTask = taskRepository.save(task);

        //we return it as a DTO
        return modelMapper.map(updatedTask, TaskDto.class);




    }

    @Override
    public TaskDto inCompleteTask(Long id) {
        //We need to check if it exists
        Task task =taskRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Task not found with id:"+id)
        );

        //we change its value to completed
        task.setCompleted(Boolean.FALSE);
        //we save it
        Task updatedTask = taskRepository.save(task);

        //we return it as a DTO
        return modelMapper.map(updatedTask, TaskDto.class);

    }
}
