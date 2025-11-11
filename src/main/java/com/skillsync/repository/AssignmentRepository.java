package com.skillsync.repository;

import com.skillsync.model.Assignment;
import com.skillsync.model.Employee;
import com.skillsync.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByEmployee(Employee employee);

    List<Assignment> findByTask(Task task);

    List<Assignment> findByEstado(String estado);

    List<Assignment> findByEstadoNot(String estado);

    void deleteByTask(Task task);
}

