package com.codingshuttle.mappinghomework.DTO;

import com.codingshuttle.mappinghomework.entities.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {

    private Long id;
    private String title;
    @JsonIgnore
    private List<SubjectDTO> subjects;
}
