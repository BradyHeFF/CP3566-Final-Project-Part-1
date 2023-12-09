package com.example.educationsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cna/program")
public class ProgramController {

    @Autowired
    private ProgramRepository programRepository;

    @PostMapping
    public Program addProgram(@RequestBody Program program) {
        return programRepository.save(program);
    }

    @GetMapping
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    @GetMapping("/{id}")
    public Program getProgramById(@PathVariable Long id) {
        return programRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Program updateProgram(@PathVariable Long id, @RequestBody Program programDetails) {
        Program program = programRepository.findById(id).orElse(null);
        if (program != null) {
            program.setProgramName(programDetails.getProgramName());
            program.setCampus(programDetails.getCampus());
            return programRepository.save(program);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProgram(@PathVariable Long id) {
        programRepository.deleteById(id);
    }
}