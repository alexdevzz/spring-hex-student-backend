package com.backend.student.app.infrastructure.adapters.output.database.postgres.repository;

import com.backend.student.app.infrastructure.adapters.output.database.postgres.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {

}
