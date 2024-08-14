package com.codingshuttle.mappinghomework;

import com.codingshuttle.mappinghomework.Controller.ProfessorController;
import com.codingshuttle.mappinghomework.DTO.ProfessorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MappinghomeworkApplicationTests {

	@Autowired
	ProfessorController professorController;
	@Test
	void contextLoads() {
	}

	@Test
	void createProfeesor(){
		ProfessorDTO professorDTO=new ProfessorDTO();
		professorDTO.setTitle("Testttt");
		professorController.createProfessor(professorDTO);
	}

}
