package com.skillsync.mapper;

import com.skillsync.dto.AssignmentDTO;
import com.skillsync.model.Assignment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    AssignmentMapper INSTANCE = Mappers.getMapper(AssignmentMapper.class);

    @Mapping(source = "task.id", target = "taskId")
    @Mapping(source = "employee.id", target = "employeeId")
    AssignmentDTO toDTO(Assignment assignment);
}
