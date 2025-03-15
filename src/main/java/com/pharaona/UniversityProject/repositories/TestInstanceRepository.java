package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Test;
import com.pharaona.UniversityProject.models.TestInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestInstanceRepository extends JpaRepository<TestInstance, Integer> {
}
