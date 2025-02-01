package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
}
