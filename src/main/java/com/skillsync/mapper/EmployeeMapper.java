package com.skillsync.mapper;

import com.skillsync.dto.EmployeeDTO;
import com.skillsync.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {SkillMapper.class})
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO dto);
}
