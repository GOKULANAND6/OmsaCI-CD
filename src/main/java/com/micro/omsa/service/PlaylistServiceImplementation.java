package com.micro.omsa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.micro.omsa.model.Playlist;
import com.micro.omsa.repo.PlaylistRepo;

@Service
public class PlaylistServiceImplementation implements PlaylistService 
{

    PlaylistRepo repo;

    public PlaylistServiceImplementation(PlaylistRepo repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public void addPlaylist(Playlist playlist) {
        repo.savePlaylist(playlist);
    }

    @Override
    public List<Playlist> getallPlaylists() {
        return repo.findAllPlaylists();
    }

    @Override
    @Transactional
    public void updatePlaylist(Playlist playlist) {
        repo.updatePlaylist(playlist);
    }

    @Override
    @Transactional
    public void deletePlaylist(int playlistId) {
        repo.deletePlaylistById(playlistId);
    }

    @Override
    public List<Playlist> readPlaylistById(List<Integer> playlistIds) {
        return repo.findPlaylistById(playlistIds);
    }
}
