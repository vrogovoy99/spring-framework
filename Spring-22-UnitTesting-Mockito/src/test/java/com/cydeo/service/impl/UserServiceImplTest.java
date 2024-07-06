package com.cydeo.service.impl;

import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class UserServiceImplTest {

    // 1. define class that will be mocked
    @Mock
    UserRepository userRepository;

    // 2. inject mocked class into class that will be tested
    //      NOTE: UserServiceImpl injects UserRepository reference
    @InjectMocks
    UserServiceImpl userService;

    @Test
    void  deleteByUsername_test(){

        // 3. call method that will be tested
        userService.deleteByUserName("mikesmith@cydeo.com");

        // 4. define method that will be used in mocked class
        //    userService.deleteByUserName uses userRepository.deleteByUserName to delete a user
        verify(userRepository).deleteByUserName("mikesmith@cydeo.com");

        verify(userRepository).deleteByUserName("mikesmith@cydeo.com");
//        verify(userRepository, times(2)).deleteByUserName("mikesmith@cydeo.com");
//        verify(userRepository, atLeastOnce()).deleteByUserName("mikesmith@cydeo.com");
//        verify(userRepository, atLeast(5)).deleteByUserName("mikesmith@cydeo.com");
//        verify(userRepository, atMostOnce()).deleteByUserName("mikesmith@cydeo.com");
//        verify(userRepository, atMost(5)).deleteByUserName("mikesmith@cydeo.com");

        InOrder inOrder = inOrder(userRepository);

        inOrder.verify(userRepository).deleteByUserName("mikesmith@cydeo.com");
        inOrder.verify(userRepository).findAll();
    }

}