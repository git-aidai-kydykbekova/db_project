package org.example.dp_project.service.impl;

import org.example.dp_project.dto.InstructorDto;
import org.example.dp_project.entity.Course;
import org.example.dp_project.entity.Instructor;
import org.example.dp_project.repository.InstructorRepository;
import org.example.dp_project.service.InstructorService;
import org.example.dp_project.utils.exception.AlreadyExistException;
import org.example.dp_project.utils.exception.ObjectNotFoundException;
import org.example.dp_project.utils.mapper.InstructorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public InstructorServiceImpl(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    private boolean isIdExist(Long id) {
        if (instructorRepository.existsById(id))
            throw new AlreadyExistException("Instructor", "id");
        return false;
    }

    private boolean isEmailExist(String name) {
        if (instructorRepository.isEmailExist(name))
            throw new AlreadyExistException("Instructor", "email");
        return false;
    }

    private Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Instructor"));
    }

    @Override
    public Instructor getInstructorEntityByName(String name) {
        return instructorRepository.findByName(name)
                .orElseThrow(() -> new ObjectNotFoundException("Instructor"));
    }

    @Override
    public List<InstructorDto> getInstructorByName(String name) {
        return instructorMapper.entityToDtoList(instructorRepository.findByNameContains(name));
    }

    @Override
    public List<InstructorDto> getAllInstructors() {
        return instructorMapper.entityToDtoList(instructorRepository.findAll());
    }

    @Override
    public InstructorDto createInstructor(InstructorDto instructorDto) {
        if (!isEmailExist(instructorDto.getName()))
            return instructorMapper.entityToDto(save(instructorMapper.dtoToEntity(instructorDto)));
        return null;
    }

    @Override
    public InstructorDto updateInstructor(InstructorDto instructorDto) {
        Instructor oldInstructor = instructorMapper.dtoToEntity(instructorDto);
        Instructor newInstructor = getInstructorEntityByName(instructorDto.getName());

        if (!newInstructor.getEmail().equals(oldInstructor.getEmail()))
            isEmailExist(oldInstructor.getEmail());

        if (!(oldInstructor.getName() == null))
            newInstructor.setName(oldInstructor.getName());
        if (!(oldInstructor.getEmail() == null))
            newInstructor.setEmail(oldInstructor.getEmail());
        if (!(oldInstructor.getBio() == null))
            newInstructor.setBio(oldInstructor.getBio());

        return instructorMapper.entityToDto(save(newInstructor));
    }
}
