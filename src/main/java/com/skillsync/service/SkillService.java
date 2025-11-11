package com.skillsync.service;

import com.skillsync.model.Skill;
import java.util.List;

public interface SkillService {
    List<Skill> getAllSkills();
    Skill getSkillById(Long id);
    Skill saveSkill(Skill skill);
    void deleteSkill(Long id);
}