package com.skillsync.service.impl;

import com.skillsync.model.Skill;
import com.skillsync.repository.SkillRepository;
import com.skillsync.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habilidad no encontrada con ID: " + id));
    }

    @Override
    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
