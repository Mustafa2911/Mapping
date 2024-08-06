package com.codingshuttle.mappinghomework.Controller;

import com.codingshuttle.mappinghomework.DTO.ProfessorDTO;
import com.codingshuttle.mappinghomework.Service.ProfessorService;
import com.codingshuttle.mappinghomework.entities.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;


    @PostMapping
    public ProfessorDTO createProfessor(@RequestBody ProfessorDTO professor){
        System.out.println("Professor data:::"+professor);
        return professorService.createProfessor(professor);

    }

    @PutMapping("/{professorId}/assignSubjectToProfessor/{subjectId}")
    public ProfessorDTO assignSubjectToProfessor(@PathVariable Long professorId,@PathVariable Long subjectId ){
        return professorService.assignSubjectToProfessor(professorId,subjectId);

    }

    @GetMapping("/{id}")
    public ProfessorDTO getProfessorById(@PathVariable Long id){
        return professorService.getProfessorById(id);

    }
}
