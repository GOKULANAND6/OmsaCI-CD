package com.micro.omsa.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.micro.omsa.model.History;
import com.micro.omsa.model.Song;
import com.micro.omsa.model.UserSignup;
import com.micro.omsa.service.HistoryServiceImplementation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/history")
@CrossOrigin(origins = "http://localhost:3000")
public class HistoryController {

    private final HistoryServiceImplementation service;

    @PersistenceContext
    private EntityManager entityManager;

    public HistoryController(HistoryServiceImplementation service) {
        this.service = service;
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<String> insertHistory(
            @PathVariable("userId") int userId,
            @RequestBody List<Integer> songIds) {
        try {
            UserSignup user = new UserSignup();
            user.setUserId(userId);

            // Fetch managed Song entities
            List<Song> songList = songIds.stream()
                    .map(songId -> {
                        Song song = entityManager.find(Song.class, songId);
                        if (song == null) {
                            throw new RuntimeException("Song not found with ID: " + songId);
                        }
                        return song;
                    })
                    .collect(Collectors.toList());

            History history = new History();
            history.setUser(user);
            history.setSongs(songList);

            service.addHistory(history);

            return ResponseEntity.status(HttpStatus.CREATED).body("History record added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Add: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<History>> readAllHistories() {
        try {
            List<History> histories = service.getallHistorys();
            return ResponseEntity.ok(histories);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<String> updateHistory(@RequestBody History history) {
        try {
            service.updateHistory(history);
            return ResponseEntity.ok("Successfully Updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Update");
        }
    }

    @DeleteMapping("/{historyId}")
    public ResponseEntity<String> deleteHistoryById(@PathVariable("historyId") int historyId) {
        try {
            service.deleteHistory(historyId);
            return ResponseEntity.ok("Successfully Deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Delete");
        }
    }
}
