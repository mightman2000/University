package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Lesson;
import com.pharaona.UniversityProject.models.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
