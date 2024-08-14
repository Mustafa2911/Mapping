package com.codingshuttle.mappinghomework.Repositories;

import com.codingshuttle.mappinghomework.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepositories extends JpaRepository<Professor,Long> {
    Professor findByTitle(String title);
}
