package com.skillsync.controller;

import com.skillsync.model.Skill;
import com.skillsync.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "*")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<Skill> getAll() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getById(@PathVariable Long id) {
        return ResponseEntity.ok(skillService.getSkillById(id));
    }

    @PostMapping
    public ResponseEntity<Skill> create(@RequestBody Skill skill) {
        return ResponseEntity.ok(skillService.saveSkill(skill));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> update(@PathVariable Long id, @RequestBody Skill skill) {
        skill.setId(id);
        return ResponseEntity.ok(skillService.saveSkill(skill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }
}
