package com.example.educationsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cna/grades")
public class GradesController {

    @Autowired
    private GradesRepository gradesRepository;

    @PostMapping
    public Grades addGrade(@RequestBody Grades grades) {
        return gradesRepository.save(grades);
    }

    @GetMapping
    public List<Grades> getAllGrades() {
        return gradesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Grades getGradeById(@PathVariable Long id) {
        return gradesRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Grades updateGrade(@PathVariable Long id, @RequestBody Grades gradeDetails) {
        Grades grade = gradesRepository.findById(id).orElse(null);
        if (grade != null) {
            grade.setStudentId(gradeDetails.getStudentId());
            grade.setCourseId(gradeDetails.getCourseId());
            grade.setGrade(gradeDetails.getGrade());
            return gradesRepository.save(grade);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradesRepository.deleteById(id);
    }
}
