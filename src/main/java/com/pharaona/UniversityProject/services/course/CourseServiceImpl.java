package com.pharaona.UniversityProject.services.course;

import com.pharaona.UniversityProject.models.Course;
import com.pharaona.UniversityProject.models.Department;
import com.pharaona.UniversityProject.models.Speciality;
import com.pharaona.UniversityProject.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository theCourseRepository) {
        courseRepository = theCourseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(Course theCourse) {
        return courseRepository.save(theCourse);
    }

    @Override
    public Course findById(int theId) {
        Optional<Course> result = courseRepository.findById(theId);

        Course theCourse = null;

        if (result.isPresent()) {
            theCourse = result.get();
        }
        else {

            throw new RuntimeException("Did not find course id - " + theId);
        }

        return theCourse;
    }

    public void deleteById(int theId) {
        courseRepository.deleteById((theId));
    }

}
