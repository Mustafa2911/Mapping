package com.codingshuttle.mappinghomework.Configurations;

import com.codingshuttle.mappinghomework.DTO.ProfessorDTO;
import com.codingshuttle.mappinghomework.DTO.SubjectDTO;
import com.codingshuttle.mappinghomework.entities.Professor;
import com.codingshuttle.mappinghomework.entities.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Professor.class, ProfessorDTO.class).addMappings(mapper -> {
            mapper.skip(ProfessorDTO::setSubjects); // Skip subjects to prevent recursion
        });

        modelMapper.typeMap(Subject.class, SubjectDTO.class).addMappings(mapper -> {
            mapper.skip(SubjectDTO::setProfessor); // Skip professor to prevent recursion
        });

        return modelMapper;
    }
}
