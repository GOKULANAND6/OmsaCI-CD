package com.micro.omsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.omsa.model.Song;
import com.micro.omsa.repo.SongRepo;

@Service
public class SongServiceImplementation implements SongService
{
	SongRepo repo;

	public SongServiceImplementation(SongRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addSong(Song song) 
	{
		repo.saveSong(song);
	}

	@Override
	public List<Song> getallSongs() 
	{
		return repo.findAllSongs();
	}

	@Override
	public void updateSong(Song song) 
	{
		repo.updateSong(song);
	}

	@Override
	public void deleteSong(int songId) 
	{
		repo.deleteSongById(songId);
	}

	@Override
	public Song findSongByName(String songName) 
	{
		return repo.findSongByName(songName);
	}

	public Song findSongById(int songId) 
	{
		return repo.findSongById(songId);
	}
}
