package com.pharaona.UniversityProject.services.material;

import com.pharaona.UniversityProject.models.Material;
import com.pharaona.UniversityProject.repositories.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {

    private MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository theMaterialRepository) {
        materialRepository = theMaterialRepository;
    }

    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Material save(Material theMaterial) {
        return materialRepository.save(theMaterial);
    }

    @Override
    public Material findById(int theId) {
        Optional<Material> result = materialRepository.findById(theId);

        Material theMaterial = null;

        if (result.isPresent()) {
            theMaterial = result.get();
        }
        else {

            throw new RuntimeException("Did not find material id - " + theId);
        }

        return theMaterial;
    }

    public void deleteById(int theId) {
        materialRepository.deleteById((theId));
    }

}
