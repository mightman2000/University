package com.pharaona.UniversityProject.repositories;

import com.pharaona.UniversityProject.models.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurriculumRepository extends JpaRepository<Curriculum, Integer> {

    @Query("SELECT c FROM Curriculum c LEFT JOIN FETCH c.disciplineCurriculums dc LEFT JOIN FETCH dc.discipline d")
    List<Curriculum> findAllWithDisciplines();
}
