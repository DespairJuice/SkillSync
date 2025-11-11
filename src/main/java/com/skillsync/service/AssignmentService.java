package com.skillsync.service;

import com.skillsync.model.Assignment;

import java.util.List;

public interface AssignmentService {
    Assignment generateAssignment(Long taskId);
    Assignment createAssignment(Assignment assignment);
    List<Assignment> getAllAssignments();
    Assignment updateAssignment(Long id, Assignment assignment);
    void deleteAssignment(Long id);
}
