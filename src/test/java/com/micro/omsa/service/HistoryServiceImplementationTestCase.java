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

import com.micro.omsa.model.History;
import com.micro.omsa.model.UserSignup;
import com.micro.omsa.model.Song;
import com.micro.omsa.repo.HistoryRepo;

class HistoryServiceImplementationTestCase {

    @Mock
    private HistoryRepo repo;

    @InjectMocks
    private HistoryServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddHistory() {
        UserSignup user = new UserSignup();
        List<Song> songs = Arrays.asList(new Song(), new Song()); 
        History history = new History(1, user, songs);
        doNothing().when(repo).saveHistory(history);

        service.addHistory(history);

        verify(repo).saveHistory(history);
    }

    @Test
    void testGetAllHistorys() {
        UserSignup user = new UserSignup();
        List<Song> songs = Arrays.asList(new Song(), new Song());
        History history1 = new History(1, user, songs);
        History history2 = new History(2, user, songs);
        List<History> histories = Arrays.asList(history1, history2);
        when(repo.findAllHistorys()).thenReturn(histories);

        List<History> result = service.getallHistorys();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(history1));
        assertTrue(result.contains(history2));
        verify(repo).findAllHistorys();
    }

    @Test
    void testUpdateHistory() {
        UserSignup user = new UserSignup();
        List<Song> songs = Arrays.asList(new Song(), new Song());
        History history = new History(1, user, songs);
        doNothing().when(repo).updateHistory(history);

        service.updateHistory(history);

        verify(repo).updateHistory(history);
    }

    @Test
    void testDeleteHistory() {
        int historyId = 1;
        doNothing().when(repo).deleteHistoryById(historyId);

        service.deleteHistory(historyId);

        verify(repo).deleteHistoryById(historyId);
    }
}
