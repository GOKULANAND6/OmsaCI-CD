package com.micro.omsa.repo;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.micro.omsa.model.Playlist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PlaylistRepoImplementation implements PlaylistRepo 
{
	EntityManager manager;

    public PlaylistRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
    public void savePlaylist(Playlist playlist) {
        manager.persist(playlist);
    }

    @Override
    public List<Playlist> findAllPlaylists() {
        String str = "FROM Playlist";
        Query query = manager.createQuery(str);
        return query.getResultList();
    }

    @Override
    public void updatePlaylist(Playlist playlist) {
        manager.merge(playlist);
    }

    @Override
    public void deletePlaylistById(int playlistId) {
        Playlist playlist = manager.find(Playlist.class, playlistId);
        if (playlist != null) {
            manager.remove(playlist);
        } else {
            throw new RuntimeException("Playlist not found for ID: " + playlistId);
        }
    }

    @Override
    public List<Playlist> findPlaylistById(List<Integer> playlistId) {
        if (playlistId == null || playlistId.isEmpty()) {
            return List.of();
        }

        String str = "SELECT p FROM Playlist p WHERE p.playlistId IN :playlistId";
        Query query = manager.createQuery(str);
        query.setParameter("playlistId", playlistId);
        return query.getResultList();
    }


}
