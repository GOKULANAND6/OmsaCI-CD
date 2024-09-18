package com.micro.omsa.repo;

import java.util.List;

import com.micro.omsa.model.Playlist;

public interface PlaylistRepo 
{
	public void savePlaylist(Playlist playlist);

	public List<Playlist> findAllPlaylists();

	public void updatePlaylist(Playlist playlist);

	public void deletePlaylistById(int playlistId);
	
	public List<Playlist> findPlaylistById(List<Integer> playlistId);
}
