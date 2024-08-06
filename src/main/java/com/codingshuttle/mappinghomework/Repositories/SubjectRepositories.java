package com.codingshuttle.mappinghomework.Repositories;

import com.codingshuttle.mappinghomework.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepositories extends JpaRepository<Subject,Long> {
}
