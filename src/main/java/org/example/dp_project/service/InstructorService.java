package org.example.dp_project.service;


import org.example.dp_project.dto.InstructorDto;
import org.example.dp_project.entity.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor getInstructorById(Long id);
    Instructor getInstructorEntityByName(String name);

    List<InstructorDto> getInstructorByName(String name);
    List<InstructorDto> getAllInstructors();

    InstructorDto createInstructor(InstructorDto instructorDto);
    InstructorDto updateInstructor(InstructorDto instructorDto);
}
