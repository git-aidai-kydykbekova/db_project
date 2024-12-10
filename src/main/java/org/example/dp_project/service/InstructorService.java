package org.example.dp_project.service;


import org.example.database_project.dto.InstructorDto;
import org.example.database_project.entity.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor getInstructorById(Long id);
    List<InstructorDto> getInstructorByName(String name);
    List<InstructorDto> getAllInstructors();

    InstructorDto createInstructor(InstructorDto instructorDto);
    InstructorDto updateInstructor(InstructorDto instructorDto);
}
