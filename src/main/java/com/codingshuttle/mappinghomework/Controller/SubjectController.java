package com.codingshuttle.mappinghomework.Controller;

import com.codingshuttle.mappinghomework.DTO.ProfessorDTO;
import com.codingshuttle.mappinghomework.DTO.SubjectDTO;
import com.codingshuttle.mappinghomework.Service.ProfessorService;
import com.codingshuttle.mappinghomework.Service.SubjectService;
import com.codingshuttle.mappinghomework.entities.Professor;
import com.codingshuttle.mappinghomework.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;


    @PostMapping
    public SubjectDTO createSubject(@RequestBody Subject subject){
        System.out.println("Subject data:::"+subject);
        return subjectService.createSubject(subject);

    }



}
