package com.micro.omsa.repo;

import java.util.List;

import com.micro.omsa.model.Song;

public interface SongRepo 
{
	public void saveSong(Song song);

	public List<Song> findAllSongs();

	public void updateSong(Song song);

	public void deleteSongById(int songId);
	
	public Song findSongById(int songId);
		
	public Song findSongByName(String songName);

}
