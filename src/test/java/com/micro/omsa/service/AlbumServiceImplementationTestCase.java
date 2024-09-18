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

import com.micro.omsa.model.Album;
import com.micro.omsa.repo.AlbumRepo;

class AlbumServiceImplementationTestCase {

    @Mock
    private AlbumRepo repo;

    @InjectMocks
    private AlbumServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddAlbum() {
        Album album = new Album(1, new byte[]{1, 2, 3}, "Tamil", "Mankatha", "Yuvan");
        doNothing().when(repo).saveAlbum(album);

        service.addAlbum(album);

        verify(repo).saveAlbum(album);
    }

    @Test
    void testGetAllAlbums() {
        Album album1 = new Album(1, new byte[]{1, 2, 3}, "Tamil", "Mankatha", "Yuvan");
        Album album2 = new Album(2, new byte[]{4, 5, 6}, "Tamil", "Aarambam", "Yuvan");
        List<Album> albums = Arrays.asList(album1, album2);
        when(repo.findAllAlbums()).thenReturn(albums);

        List<Album> result = service.getallAlbums();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(album1));
        assertTrue(result.contains(album2));
        verify(repo).findAllAlbums();
    }

    @Test
    void testUpdateAlbum() {
        Album album = new Album(1, new byte[]{1, 2, 3}, "Tamil", "Mankatha", "Yuvan");
        doNothing().when(repo).updateAlbum(album);

        service.updateAlbum(album);

        verify(repo).updateAlbum(album);
    }

    @Test
    void testDeleteAlbum() {
        int albumId = 1;
        doNothing().when(repo).deleteAlbumById(albumId);

        service.deleteAlbum(albumId);

        verify(repo).deleteAlbumById(albumId);
    }

    @Test
    void testFindAlbumByName() {
        Album album = new Album(1, new byte[]{1, 2, 3}, "Tamil", "Mankatha", "Yuvan");
        when(repo.findAlbumByName("Mankatha")).thenReturn(album);

        Album result = service.findAlbumByName("Mankatha");

        assertNotNull(result);
        assertEquals(album.getAlbumName(), result.getAlbumName());
        assertEquals(album.getAlbumLanguage(), result.getAlbumLanguage());
        verify(repo).findAlbumByName("Mankatha");
    }

    @Test
    void testFindAlbumById() {
        Album album = new Album(1, new byte[]{1, 2, 3}, "Tamil", "Mankatha", "Yuvan");
        when(repo.findAlbumById(1)).thenReturn(album);

        Album result = service.findAlbumById(1);

        assertNotNull(result);
        assertEquals(album.getAlbumId(), result.getAlbumId());
        assertEquals(album.getAlbumName(), result.getAlbumName());
        assertEquals(album.getAlbumLanguage(), result.getAlbumLanguage());
        verify(repo).findAlbumById(1);
    }
}
