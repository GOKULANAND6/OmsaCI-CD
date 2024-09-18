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
import com.micro.omsa.model.Song;
import com.micro.omsa.repo.SongRepo;

class SongServiceImplementationTestCase {

    @Mock
    private SongRepo repo;

    @InjectMocks
    private SongServiceImplementation service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddSong() {
        byte[] songImage = new byte[1];
        byte[] songMp3 = new byte[1];  
        Song song = new Song(1, songImage, songMp3, "Mankatha Theme Music", "Instrument", new Album());

        doNothing().when(repo).saveSong(song);

        service.addSong(song);

        verify(repo).saveSong(song);
    }

    @Test
    void testGetAllSongs() {
        byte[] songImage = new byte[1];
        byte[] songMp3 = new byte[1];
        Song song1 = new Song(1, songImage, songMp3, "Mankatha Theme Music", "Instrument", new Album());
        Song song2 = new Song(2, songImage, songMp3, "En Nanbaney", "Maanasi", new Album());
        List<Song> songs = Arrays.asList(song1, song2);

        when(repo.findAllSongs()).thenReturn(songs);

        List<Song> result = service.getallSongs();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(song1));
        assertTrue(result.contains(song2));
        verify(repo).findAllSongs();
    }

    @Test
    void testUpdateSong() {
        byte[] songImage = new byte[1];
        byte[] songMp3 = new byte[1];
        Song song = new Song(1, songImage, songMp3, "Mankatha Theme Music", "Yuvan", new Album());

        doNothing().when(repo).updateSong(song);

        service.updateSong(song);

        verify(repo).updateSong(song);
    }

    @Test
    void testDeleteSong() {
        int songId = 1;
        doNothing().when(repo).deleteSongById(songId);

        service.deleteSong(songId);

        verify(repo).deleteSongById(songId);
    }

    @Test
    void testFindSongByName() {
        String songName = "Mankatha Theme Music";
        byte[] songImage = new byte[1];
        byte[] songMp3 = new byte[1];
        Song song = new Song(1, songImage, songMp3, songName, "Yuvan", new Album());

        when(repo.findSongByName(songName)).thenReturn(song);

        Song result = service.findSongByName(songName);

        assertNotNull(result);
        assertEquals(songName, result.getSongName());
        verify(repo).findSongByName(songName);
    }

    @Test
    void testFindSongById() {
        int songId = 1;
        byte[] songImage = new byte[1];
        byte[] songMp3 = new byte[1];
        Song song = new Song(songId, songImage, songMp3, "Mankatha Theme Music", "Yuvan", new Album());

        when(repo.findSongById(songId)).thenReturn(song);

        Song result = service.findSongById(songId);

        assertNotNull(result);
        assertEquals(songId, result.getSongId());
        verify(repo).findSongById(songId);
    }
}
