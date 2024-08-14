package com.codingshuttle.mappinghomework.Controller;

import com.codingshuttle.mappinghomework.DTO.ProfessorDTO;
import com.codingshuttle.mappinghomework.Service.ProfessorService;
import com.codingshuttle.mappinghomework.entities.Professor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    Logger log= LoggerFactory.getLogger(ProfessorController.class);


    @PostMapping
    public ProfessorDTO createProfessor(@RequestBody ProfessorDTO professor){
        log.info("create professor log");
        log.error("create professor log");
        log.warn("create professor log");
        log.trace("create professor log");
        log.debug("create professor log");
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

    @GetMapping("/subject/{id}")
    public ProfessorDTO getProfessorWithSubjectId(@PathVariable Long id){
        return professorService.getProfessorWithSubjectId(id);
    }
}
