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

import com.micro.omsa.model.Premium;
import com.micro.omsa.repo.PremiumRepo;

class PremiumServiceImplementationTestCase {

    @Mock
    private PremiumRepo repo;

    @InjectMocks
    private PremiumServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPremium() {
        Premium premium = new Premium(1, "Premium Micro", "1 Year", "249", "Access to all features");
        doNothing().when(repo).savePremium(premium);

        service.addPremium(premium);

        verify(repo).savePremium(premium);
    }

    @Test
    void testGetAllPremiums() {
        Premium premium1 = new Premium(1, "Premium Micro", "1 Year", "249", "Access to all features");
        Premium premium2 = new Premium(2, "Premium Nano", "6 Months", "149", "Limited features");
        List<Premium> premiums = Arrays.asList(premium1, premium2);
        when(repo.findAllPremiums()).thenReturn(premiums);

        List<Premium> result = service.getallPremiums();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(premium1));
        assertTrue(result.contains(premium2));
        verify(repo).findAllPremiums();
    }

    @Test
    void testUpdatePremium() {
        Premium premium = new Premium(1, "Premium Micro", "2 Years", "349", "All features included");
        doNothing().when(repo).updatePremium(premium);

        service.updatePremium(premium);

        verify(repo).updatePremium(premium);
    }

    @Test
    void testDeletePremium() {
        int premiumId = 1;
        doNothing().when(repo).deletePremiumById(premiumId);

        service.deletePremium(premiumId);

        verify(repo).deletePremiumById(premiumId);
    }

    @Test
    void testFindPremiumById() {
        int premiumId = 1;
        Premium premium = new Premium(premiumId, "Premium Micro", "1 Year", "249", "Access to all features");
        when(repo.findPremiumById(premiumId)).thenReturn(premium);

        Premium result = service.findPremiumById(premiumId);

        assertNotNull(result);
        assertEquals(premiumId, result.getPremiumId());
        assertEquals("Premium Micro", result.getPremiumName());
        verify(repo).findPremiumById(premiumId);
    }
}
