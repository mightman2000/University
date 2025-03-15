package com.pharaona.UniversityProject.services.material;

import com.pharaona.UniversityProject.models.Material;

import java.util.List;

public interface MaterialService {

    List<Material> findAll();

    Material save(Material theMaterial);

    Material findById(int theId);

    void deleteById(int theId);

}
