package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class eProjectServiceImplTest {

//    1. mock classes used in tested class projectService.getByProjectCode
    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

//    2. Inject mock classes into tested class
    @InjectMocks
    ProjectServiceImpl projectService;

//    3. Define test method
    @Test
    void getByProjectCode_test() {

        // Given
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

//        4. Predefine return objects for the functions used in tested method

        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);
        when(projectMapper.convertToDto(project)).thenReturn(projectDTO);

//        5. actual test calling tested method
        // When
        ProjectDTO projectDTO1 = projectService.getByProjectCode(anyString());

//        6. valudate test method execution ensuring all classes are executed
        // Then
        verify(projectRepository).findByProjectCode(anyString());
        verify(projectMapper).convertToDto(any(Project.class));

//        7. validate the test return value
        assertNotNull(projectDTO1);

    }

    @Test
    void getByProjectCode_exception_test() {

        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project Not Found"));

        Throwable exception = assertThrows(RuntimeException.class, () -> projectService.getByProjectCode("Aha!"));

//        verify(projectRepository).findByProjectCode(anyString());

        assertEquals("Project Not Found", exception.getMessage());

    }

    @Test
    void save_test() {

        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();

        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        projectService.save(projectDTO);

        verify(projectRepository).save(project);
        verify(projectMapper).convertToEntity(any(ProjectDTO.class));

    }

}
