package com.rogersentongo.taskmanagement.repository;

import com.rogersentongo.taskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
