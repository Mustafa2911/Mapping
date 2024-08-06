package com.codingshuttle.mappinghomework.Service;

import com.codingshuttle.mappinghomework.DTO.ProfessorDTO;
import com.codingshuttle.mappinghomework.DTO.SubjectDTO;
import com.codingshuttle.mappinghomework.Repositories.ProfessorRepositories;
import com.codingshuttle.mappinghomework.Repositories.SubjectRepositories;
import com.codingshuttle.mappinghomework.entities.Professor;
import com.codingshuttle.mappinghomework.entities.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepositories professorRepositories;
    @Autowired
    private SubjectRepositories subjectRepositories;

    @Autowired
   private ModelMapper modelMapper;

    public ProfessorDTO createProfessor(ProfessorDTO professor){
        Professor prof= professorRepositories.save(modelMapper.map(professor,Professor.class));
        return modelMapper.map(prof,ProfessorDTO.class);
    }

    public ProfessorDTO assignSubjectToProfessor(Long professorId, Long subjectId) {
        Optional<Subject> subject=subjectRepositories.findById(subjectId);
        Optional<Professor> professor=professorRepositories.findById(professorId);

        Professor professorEntity= subject.map(subject1 -> {
            return professor.map(professor1 -> {
                subject1.setProfessor(professor1);
                subjectRepositories.save(subject1);
                professor1.getSubjects().add(subject1);
                return professor1;
            }).orElseThrow(() -> new IllegalStateException("Professor not found"));
        }).orElse(null);

        return modelMapper.map(professorEntity,ProfessorDTO.class);
    }

    public ProfessorDTO getProfessorById(Long id) {
        Professor professor= professorRepositories.findById(id).orElse(null);
        ProfessorDTO professorDTO= modelMapper.map(professor,ProfessorDTO.class);
        List<Subject>subjects=professor.getSubjects();
        List<SubjectDTO> subjectDTOS= subjects.stream()
                .map(subject -> modelMapper.map(subject, SubjectDTO.class))
                .collect(Collectors.toList());
        professorDTO.setSubjects(subjectDTOS);
        return professorDTO;

    }
}
