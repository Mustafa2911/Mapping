package com.codingshuttle.mappinghomework.Service;

import com.codingshuttle.mappinghomework.DTO.SubjectDTO;
import com.codingshuttle.mappinghomework.Repositories.SubjectRepositories;
import com.codingshuttle.mappinghomework.entities.Professor;
import com.codingshuttle.mappinghomework.entities.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepositories subjectRepositories;
    private final ModelMapper modelMapper=new ModelMapper();

    public SubjectDTO createSubject(Subject subject) {

        Subject subject1= subjectRepositories.save(subject);
        return modelMapper.map(subject1,SubjectDTO.class);
    }
}
