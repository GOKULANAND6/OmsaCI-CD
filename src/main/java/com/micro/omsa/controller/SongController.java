package com.micro.omsa.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.micro.omsa.model.Album;
import com.micro.omsa.model.Song;
import com.micro.omsa.service.AlbumServiceImplementation;
import com.micro.omsa.service.SongServiceImplementation;

@RestController
@RequestMapping("/song")
@CrossOrigin(origins = "http://localhost:3000")
public class SongController {

    private final SongServiceImplementation songService;
    private final AlbumServiceImplementation albumService;

    public SongController(SongServiceImplementation songService, AlbumServiceImplementation albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> insertSong(
            @RequestParam("songImage") MultipartFile songImage,
            @RequestParam("songMp3") MultipartFile songMp3,
            @RequestParam("songName") String songName,
            @RequestParam("songSinger") String songSinger,
            @RequestParam("albumId") int albumId) throws IOException {

        Album album = albumService.findAlbumById(albumId);

        if (album == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Album not found");
        }

        Song song = new Song();
        song.setSongName(songName);
        song.setSongSinger(songSinger);
        song.setAlbum(album);

        if (songImage != null && !songImage.isEmpty()) {
            song.setSongImage(songImage.getBytes());
        }

        if (songMp3 != null && !songMp3.isEmpty()) {
            song.setSongMp3(songMp3.getBytes());
        }

        songService.addSong(song);

        return ResponseEntity.ok("Song added successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Song>> readAllSongs() {
        List<Song> songs = songService.getallSongs();
        return ResponseEntity.ok(songs);
    }

    @PutMapping
    public ResponseEntity<String> updateSong(@RequestBody Song song) {
        try {
            songService.updateSong(song);
            return ResponseEntity.ok("Successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update");
        }
    }

    @DeleteMapping("/{songId}")
    public ResponseEntity<String> deleteSongById(@PathVariable("songId") int songId) {
        try {
            songService.deleteSong(songId);
            return ResponseEntity.ok("Successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete");
        }
    }

    @GetMapping("/findByName/{songName}")
    public ResponseEntity<Song> findSongByName(@PathVariable("songName") String songName) {
        Song song = songService.findSongByName(songName);
        if (song != null) {
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    @GetMapping("/findById/{songId}")
    public ResponseEntity<Song> findSongById(@PathVariable("songId") int songId) {
        Song song =  songService.findSongById(songId);
        if (song != null) {
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
