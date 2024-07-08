package com.cydeo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.repository.RoleRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RoleServiceImpl.class, RoleMapper.class, MapperUtil.class, ModelMapper.class})
@ExtendWith(SpringExtension.class)
class RoleServiceImplDiffblueTest {
    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    /**
     * Method under test: {@link RoleServiceImpl#listAllRoles()}
     */
    @Test
    void testListAllRoles() {
        // Arrange
        when(roleRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<RoleDTO> actualListAllRolesResult = roleServiceImpl.listAllRoles();

        // Assert
        verify(roleRepository).findAll();
        assertTrue(actualListAllRolesResult.isEmpty());
    }

    /**
     * Method under test: {@link RoleServiceImpl#listAllRoles()}
     */
    @Test
    void testListAllRoles2() {
        // Arrange
        Role role = new Role();
        role.setDescription("The characteristics of someone or something");
        role.setId(1L);
        role.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role.setInsertUserId(1L);
        role.setIsDeleted(true);
        role.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role.setLastUpdateUserId(1L);

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);
        when(roleRepository.findAll()).thenReturn(roleList);

        // Act
        List<RoleDTO> actualListAllRolesResult = roleServiceImpl.listAllRoles();

        // Assert
        verify(roleRepository).findAll();
        assertEquals(1, actualListAllRolesResult.size());
        RoleDTO getResult = actualListAllRolesResult.get(0);
        assertEquals("The characteristics of someone or something", getResult.getDescription());
        assertEquals(1L, getResult.getId().longValue());
    }

    /**
     * Method under test: {@link RoleServiceImpl#listAllRoles()}
     */
    @Test
    void testListAllRoles3() {
        // Arrange
        Role role = new Role();
        role.setDescription("The characteristics of someone or something");
        role.setId(1L);
        role.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role.setInsertUserId(1L);
        role.setIsDeleted(true);
        role.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role.setLastUpdateUserId(1L);

        Role role2 = new Role();
        role2.setDescription("Description");
        role2.setId(2L);
        role2.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role2.setInsertUserId(2L);
        role2.setIsDeleted(false);
        role2.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role2.setLastUpdateUserId(2L);

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role2);
        roleList.add(role);
        when(roleRepository.findAll()).thenReturn(roleList);

        // Act
        List<RoleDTO> actualListAllRolesResult = roleServiceImpl.listAllRoles();

        // Assert
        verify(roleRepository).findAll();
        assertEquals(2, actualListAllRolesResult.size());
        RoleDTO getResult = actualListAllRolesResult.get(0);
        assertEquals("Description", getResult.getDescription());
        RoleDTO getResult2 = actualListAllRolesResult.get(1);
        assertEquals("The characteristics of someone or something", getResult2.getDescription());
        assertEquals(1L, getResult2.getId().longValue());
        assertEquals(2L, getResult.getId().longValue());
    }

    /**
     * Method under test: {@link RoleServiceImpl#findById(Long)}
     */
    @Test
    void testFindById() {
        // Arrange
        // TODO: Populate arranged inputs
        Long id = null;

        // Act
        RoleDTO actualFindByIdResult = this.roleServiceImpl.findById(id);

        // Assert
        // TODO: Add assertions on result
    }
}
