package com.micro.omsa.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.omsa.model.Song;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class SongRepoImplementation implements SongRepo
{
	EntityManager manager;
	
	public SongRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void saveSong(Song song) 
	{
		manager.persist(song);
	}

	@Override
	public List<Song> findAllSongs() 
	{
		String str = "From Song";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void updateSong(Song song) 
	{
		manager.merge(song);
	}

	@Override
	public void deleteSongById(int songId) 
	{
		Song song = manager.find(Song.class, songId);
		manager.remove(song);
	}

	@Override
	public Song findSongByName(String songName) 
	{
		String str = "From Song where songName=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", songName);
		return (Song) query.getSingleResult();
	}

	@Override
	public Song findSongById(int songId) 
	{
		return manager.find(Song.class, songId);
	}
}
