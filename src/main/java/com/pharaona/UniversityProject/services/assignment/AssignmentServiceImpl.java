package com.pharaona.UniversityProject.services.assignment;

import com.pharaona.UniversityProject.models.Assignment;
import com.pharaona.UniversityProject.repositories.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentRepository assignmentRepository;

    public AssignmentServiceImpl(AssignmentRepository theAssignmentRepository) {
        assignmentRepository = theAssignmentRepository;
    }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment save(Assignment theAssignment) {
        return assignmentRepository.save(theAssignment);
    }

    @Override
    public Assignment findById(int theId) {
        Optional<Assignment> result = assignmentRepository.findById(theId);

        Assignment theAssignment = null;

        if (result.isPresent()) {
            theAssignment = result.get();
        }
        else {

            throw new RuntimeException("Did not find assignment id - " + theId);
        }

        return theAssignment;
    }

    public void deleteById(int theId) {
        assignmentRepository.deleteById((theId));
    }

}
