package com.pharaona.UniversityProject.services.specialty;

import com.pharaona.UniversityProject.models.Faculty;
import com.pharaona.UniversityProject.models.Speciality;
import com.pharaona.UniversityProject.repositories.SpecialtyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{

    private SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl(SpecialtyRepository theSpecialtyRepository) {
        specialtyRepository = theSpecialtyRepository;
    }

    @Override
    public List<Speciality> findAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Speciality findById(int theId) {
        Optional<Speciality> result = specialtyRepository.findById(theId);

        Speciality speciality = null;

        if (result.isPresent()) {
            speciality = result.get();
        }
        else {
            throw new RuntimeException("Did not find specialty id - " + theId);
        }
        return speciality;
    }

    @Override
    public Speciality save(Speciality theSpecialty) {
        return specialtyRepository.save(theSpecialty);
    }

    @Override
    public void deleteById(int theId) {
        specialtyRepository.deleteById((theId));
    }

}
