package com.micro.omsa.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.omsa.model.UserSignup;
import com.micro.omsa.repo.UserSignupRepo;

class UserSignupServiceImplementationTestCase {

    @Mock
    private UserSignupRepo repo;

    @InjectMocks
    private UserSignupServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser() {
        UserSignup user = new UserSignup(1, "Gokul", new Date(), "Male", "gokul@123");

        doNothing().when(repo).saveUser(user);

        service.addUser(user);

        verify(repo).saveUser(user);
    }

    @Test
    void testGetAllUsers() {
        UserSignup user1 = new UserSignup(1, "Gokul", new Date(), "Male", "gokul@123");
        UserSignup user2 = new UserSignup(2, "Anand", new Date(), "Male", "anand@123");
        List<UserSignup> users = Arrays.asList(user1, user2);

        when(repo.findAllUsers()).thenReturn(users);

        List<UserSignup> result = service.getallUsers();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(user1));
        assertTrue(result.contains(user2));
        verify(repo).findAllUsers();
    }

    @Test
    void testUpdateUser() {
        UserSignup user = new UserSignup(1, "Gokul", new Date(), "Male", "gokul@12345");

        doNothing().when(repo).updateUser(user);

        service.updateUser(user);

        verify(repo).updateUser(user);
    }

    @Test
    void testDeleteUser() {
        int userId = 1;
        doNothing().when(repo).deleteUserById(userId);

        service.deleteUser(userId);

        verify(repo).deleteUserById(userId);
    }

    @Test
    void testFindUserById() {
        int userId = 1;
        UserSignup user = new UserSignup(userId, "Gokul", new Date(), "Male", "gokul@12345");

        when(repo.findUserById(userId)).thenReturn(user);

        UserSignup result = service.findUserById(userId);

        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        verify(repo).findUserById(userId);
    }
}
