package com.micro.omsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.omsa.model.Album;
import com.micro.omsa.repo.AlbumRepo;

@Service
public class AlbumServiceImplementation implements AlbumService
{
	AlbumRepo repo;

	public AlbumServiceImplementation(AlbumRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addAlbum(Album album) 
	{
		repo.saveAlbum(album);
	}

	@Override
	public List<Album> getallAlbums() 
	{
		return repo.findAllAlbums();
	}

	@Override
	public void updateAlbum(Album album) 
	{
		repo.updateAlbum(album);
	}

	@Override
	public void deleteAlbum(int albumId) 
	{
		repo.deleteAlbumById(albumId);
	}

	@Override
	public Album findAlbumByName(String albumName) 
	{
		return repo.findAlbumByName(albumName);
	}

	@Override
	public Album findAlbumById(int albumId) 
	{
		return repo.findAlbumById(albumId);
	}
}
