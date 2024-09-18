package com.micro.omsa.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.micro.omsa.model.Playlist;
import com.micro.omsa.model.Song;
import com.micro.omsa.model.UserSignup;
import com.micro.omsa.service.PlaylistService;
import com.micro.omsa.service.SongService;
import com.micro.omsa.service.UserSignupService;

@RestController
@RequestMapping("/playlist")
@CrossOrigin(origins = "http://localhost:3000")
public class PlaylistController {

    PlaylistService playlistService;
    UserSignupService userSignupService;
    SongService songService;

    public PlaylistController(PlaylistService playlistService, UserSignupService userSignupService, SongService songService) {
        this.playlistService = playlistService;
        this.userSignupService = userSignupService;
        this.songService = songService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> insertPlaylist(
            @RequestParam("playlistName") String playlistName,
            @RequestParam("playlistImage") MultipartFile playlistImage,
            @RequestParam("userId") int userId) { // Removed songId

        try {
            Playlist playlist = new Playlist();
            UserSignup user = userSignupService.findUserById(userId);

            if (user == null) {
                return ResponseEntity.badRequest().body("User not found.");
            }

            playlist.setUser(user);

            if (playlistImage != null && !playlistImage.isEmpty()) {
                try {
                    playlist.setPlaylistImage(playlistImage.getBytes());
                } catch (IOException e) {
                    return ResponseEntity.badRequest().body("Error processing image.");
                }
            }

            playlist.setPlaylistName(playlistName);

            playlist.setSongs(new HashSet<>());

            playlistService.addPlaylist(playlist);

            return ResponseEntity.ok("Playlist added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error adding playlist.");
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<Playlist>> readAllPlaylists() {
        try {
            List<Playlist> playlists = playlistService.getallPlaylists();
            return ResponseEntity.ok(playlists);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{playlistId}/addSongs/{songId}")
    public ResponseEntity<String> addSongToPlaylist(
            @PathVariable("playlistId") int playlistId,
            @PathVariable("songId") int songId) {

        try {
            // Fetch the playlist using a list with a single ID
            List<Playlist> playlists = playlistService.readPlaylistById(List.of(playlistId));
            Playlist playlist = playlists.stream().findFirst().orElse(null);

            if (playlist == null) {
                return ResponseEntity.badRequest().body("Playlist not found.");
            }

            // Fetch the song
            Song song = songService.findSongById(songId);
            if (song == null) {
                return ResponseEntity.badRequest().body("Song not found.");
            }

            // Add the song to the playlist
            playlist.getSongs().add(song);

            // Update the playlist
            playlistService.updatePlaylist(playlist);

            return ResponseEntity.ok("Song added to playlist successfully!");
        } catch (Exception e) {
            e.printStackTrace(); // Log the detailed error
            return ResponseEntity.status(500).body("Error adding song to playlist.");
        }
    }



    @DeleteMapping("/{playlistId}")
    public ResponseEntity<String> deletePlaylistById(@PathVariable("playlistId") int playlistId) {
        try {
            playlistService.deletePlaylist(playlistId);
            return ResponseEntity.ok("Successfully deleted.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to delete.");
        }
    }

    @GetMapping("/{playlistId}")
    public ResponseEntity<Playlist> findPlaylist(@PathVariable("playlistId") int playlistId) {
        try {
            Playlist playlist = playlistService.readPlaylistById(List.of(playlistId)).stream().findFirst().orElse(null);
            if (playlist != null) {
                return ResponseEntity.ok(playlist);
            } else {
                return ResponseEntity.status(404).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
