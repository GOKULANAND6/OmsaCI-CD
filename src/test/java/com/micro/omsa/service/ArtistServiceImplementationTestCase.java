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

import com.micro.omsa.model.Artist;
import com.micro.omsa.repo.ArtistRepo;

class ArtistServiceImplementationTestCase {

    @Mock
    private ArtistRepo repo;

    @InjectMocks
    private ArtistServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddArtist() {
        Artist artist = new Artist(1, "Yuvan", new byte[]{1, 2, 3}, "1990-01-01", "Singer", "Keyboard");
        doNothing().when(repo).saveArtist(artist);

        service.addArtist(artist);

        verify(repo).saveArtist(artist);
    }

    @Test
    void testGetAllArtists() {
        Artist artist1 = new Artist(1, "Yuvan", new byte[]{1, 2, 3}, "1990-01-01", "Singer", "Keyboard");
        Artist artist2 = new Artist(2, "Imman", new byte[]{4, 5, 6}, "1992-02-02", "Singer", "Guitar");
        List<Artist> artists = Arrays.asList(artist1, artist2);
        when(repo.findAllArtists()).thenReturn(artists);

        List<Artist> result = service.getallArtists();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(artist1));
        assertTrue(result.contains(artist2));
        verify(repo).findAllArtists();
    }

    @Test
    void testUpdateArtist() {
        Artist artist = new Artist(1, "Yuvan", new byte[]{1, 2, 3}, "1990-01-01", "Singer", "Keyboard");
        doNothing().when(repo).updateArtist(artist);

        service.updateArtist(artist);

        verify(repo).updateArtist(artist);
    }

    @Test
    void testDeleteArtist() {
        int artistId = 1;
        doNothing().when(repo).deleteArtistById(artistId);

        service.deleteArtist(artistId);

        verify(repo).deleteArtistById(artistId);
    }

    @Test
    void testFindArtistById() {
        Artist artist = new Artist(1, "Yuvan", new byte[]{1, 2, 3}, "1990-01-01", "Singer", "Keyboard");
        when(repo.findArtistById(1)).thenReturn(artist);

        Artist result = service.findArtistById(1);

        assertNotNull(result);
        assertEquals(artist.getArtistId(), result.getArtistId());
        assertEquals(artist.getArtistName(), result.getArtistName());
        verify(repo).findArtistById(1);
    }

    @Test
    void testFindArtistByName() {
        Artist artist = new Artist(1, "Yuvan", new byte[]{1, 2, 3}, "1990-01-01", "Singer", "Keyboard");
        when(repo.findArtistByName("Yuvan")).thenReturn(artist);

        Artist result = service.findArtistByName("Yuvan");

        assertNotNull(result);
        assertEquals(artist.getArtistName(), result.getArtistName());
        verify(repo).findArtistByName("Yuvan");
    }
}
