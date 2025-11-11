package com.skillsync.mapper;

import com.skillsync.dto.SkillDTO;
import com.skillsync.model.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    SkillDTO toDTO(Skill skill);
    Skill toEntity(SkillDTO dto);
}
