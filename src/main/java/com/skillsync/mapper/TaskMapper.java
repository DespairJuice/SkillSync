package com.skillsync.mapper;

import com.skillsync.dto.TaskDTO;
import com.skillsync.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO toDTO(Task task);
    Task toEntity(TaskDTO dto);
}
