package com.micro.omsa.service;

import java.util.List;

import com.micro.omsa.model.Song;

public interface SongService 
{
	public void addSong(Song song);
	 
	public List<Song> getallSongs();

	public void updateSong(Song song);

	public void deleteSong(int songId);
	
	public Song findSongById(int songId);
		
	public Song findSongByName(String songName);
}
