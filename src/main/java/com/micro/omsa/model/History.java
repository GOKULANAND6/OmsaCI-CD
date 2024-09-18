package com.micro.omsa.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historyId;

    @ManyToOne(targetEntity = UserSignup.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    private UserSignup user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "history_songs",
        joinColumns = @JoinColumn(name = "historyId"),
        inverseJoinColumns = @JoinColumn(name = "songId")
    )
    private List<Song> songs;

    public History() {
        super();
    }

    public History(int historyId, UserSignup user, List<Song> songs) {
        super();
        this.historyId = historyId;
        this.user = user;
        this.songs = songs;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public UserSignup getUser() {
        return user;
    }

    public void setUser(UserSignup user) {
        this.user = user;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "History [historyId=" + historyId + ", user=" + user + ", songs=" + songs + "]";
    }
}
