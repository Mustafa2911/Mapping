package com.codingshuttle.mappinghomework.DTO;

import com.codingshuttle.mappinghomework.entities.Professor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private Long id;
    private String title;
    @JsonIgnore
    private ProfessorDTO professor;
}
