package com.skillsync.repository;

import com.skillsync.model.Task;
import com.skillsync.model.enums.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByPriority(TaskPriority priority);

    List<Task> findByRequiredSkillIgnoreCase(String requiredSkill);
}
