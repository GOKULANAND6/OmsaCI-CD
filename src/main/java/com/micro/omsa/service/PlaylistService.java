package com.micro.omsa.service;

import java.util.List;

import com.micro.omsa.model.Playlist;


public interface PlaylistService 
{
	public void addPlaylist(Playlist playlist);
	 
	public List<Playlist> getallPlaylists();

	public void updatePlaylist(Playlist playlist);

	public void deletePlaylist(int playlistId);
	
	public List<Playlist> readPlaylistById(List<Integer> playlistId); 
}
