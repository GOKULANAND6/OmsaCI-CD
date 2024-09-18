package com.micro.omsa.repo;

import java.util.List;

import com.micro.omsa.model.Album;

public interface AlbumRepo 
{
	public void saveAlbum(Album album);

	public List<Album> findAllAlbums();

	public void updateAlbum(Album album);

	public void deleteAlbumById(int albumId);
	
	public Album findAlbumById(int albumId);
		
	public Album findAlbumByName(String albumName);
}
