package com.codingshuttle.mappinghomework.Service;

import com.codingshuttle.mappinghomework.DTO.ProfessorDTO;
import com.codingshuttle.mappinghomework.DTO.SubjectDTO;
import com.codingshuttle.mappinghomework.Repositories.ProfessorRepositories;
import com.codingshuttle.mappinghomework.Repositories.SubjectRepositories;
import com.codingshuttle.mappinghomework.entities.Professor;
import com.codingshuttle.mappinghomework.entities.Subject;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
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
        Professor profTitle=professorRepositories.findByTitle(professor.getTitle());
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

    @Transactional
    public ProfessorDTO getProfessorById(Long id) {
        Professor professor = professorRepositories.findById(id).orElse(null);
        if (professor == null) {
            return null;
        }
        ModelMapper tempMapper=new ModelMapper();
        // Dynamically configure the TypeMap for this specific mapping
        TypeMap<Professor, ProfessorDTO> typeMap = tempMapper.getTypeMap(Professor.class, ProfessorDTO.class);
        if(typeMap==null){
            typeMap=tempMapper.createTypeMap(Professor.class, ProfessorDTO.class);
        }
        typeMap.addMappings(mapper -> mapper.skip(ProfessorDTO::setSubjects));
        // Perform the mapping with the specific configuration

        return typeMap.map(professor);

    }

    public ProfessorDTO getProfessorWithSubjectId(Long id) {
        Professor professor = professorRepositories.findById(id).orElse(null);

        return modelMapper.map(professor, ProfessorDTO.class);

    }
}
