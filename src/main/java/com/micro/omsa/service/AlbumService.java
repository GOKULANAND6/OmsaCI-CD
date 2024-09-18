package com.micro.omsa.service;

import java.util.List;

import com.micro.omsa.model.Album;

public interface AlbumService 
{
	public void addAlbum(Album album);
	 
	public List<Album> getallAlbums();

	public void updateAlbum(Album album);

	public void deleteAlbum(int albumId);
		
	public Album findAlbumById(int albumId);
	
	public Album findAlbumByName(String albumName);
}
