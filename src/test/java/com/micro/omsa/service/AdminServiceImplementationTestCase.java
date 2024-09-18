package com.micro.omsa.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.omsa.model.Admin;
import com.micro.omsa.repo.AdminRepo;

class AdminServiceImplementationTestCase {

    @Mock
    private AdminRepo repo;

    @InjectMocks
    private AdminServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddAdmin() {
        Admin admin = new Admin(1, "Gokul", "gokul@example.com", "1234567890", "password123");
        doNothing().when(repo).saveAdmin(admin);

        service.addAdmin(admin);

        verify(repo).saveAdmin(admin);
    }

    @Test
    void testGetAllAdmins() {
        Admin admin1 = new Admin(1, "Gokul", "gokul@example.com", "1234567890", "password123");
        Admin admin2 = new Admin(2, "Jane Doe", "jane@example.com", "0987654321", "password321");
        List<Admin> admins = Arrays.asList(admin1, admin2);
        when(repo.findAllAdmins()).thenReturn(admins);

        List<Admin> result = service.getallAdmins();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(admin1));
        assertTrue(result.contains(admin2));
        verify(repo).findAllAdmins(); 
    }

    @Test
    void testDeleteAdmin() {
        int adminId = 1;
        doNothing().when(repo).deleteAdminById(adminId);

        service.deleteAdmin(adminId);

        verify(repo).deleteAdminById(adminId);
    }

    @Test
    void testFindAdminByName() {
        Admin admin = new Admin(1, "Gokul", "gokul@example.com", "1234567890", "password123");
        when(repo.findAdminByName("Gokul")).thenReturn(admin);

        Admin result = service.findAdminByName("Gokul");

        assertNotNull(result);
        assertEquals(admin.getAdminName(), result.getAdminName());
        verify(repo).findAdminByName("Gokul");
    }
}
