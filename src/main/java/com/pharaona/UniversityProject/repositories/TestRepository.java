package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
