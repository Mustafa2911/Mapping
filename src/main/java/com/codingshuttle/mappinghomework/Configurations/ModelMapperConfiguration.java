package com.codingshuttle.mappinghomework.Configurations;

import com.codingshuttle.mappinghomework.DTO.ProfessorDTO;
import com.codingshuttle.mappinghomework.DTO.SubjectDTO;
import com.codingshuttle.mappinghomework.entities.Professor;
import com.codingshuttle.mappinghomework.entities.Subject;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMappers() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
