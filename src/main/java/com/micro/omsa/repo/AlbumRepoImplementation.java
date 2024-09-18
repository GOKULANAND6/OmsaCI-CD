package com.micro.omsa.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.omsa.model.Album;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AlbumRepoImplementation implements AlbumRepo
{
	EntityManager manager;

	public AlbumRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void saveAlbum(Album album) 
	{
		manager.persist(album);
	}

	@Override
	public List<Album> findAllAlbums() 
	{
		String str = "From Album";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void updateAlbum(Album album) 
	{
		manager.merge(album);
	}

	@Override
	public void deleteAlbumById(int albumId) 
	{
		Album album = manager.find(Album.class, albumId);
		manager.remove(album);
	}

	@Override
	public Album findAlbumByName(String albumName) 
	{
		String str = "From Album where albumName=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", albumName);
		return (Album) query.getSingleResult();
	}

	@Override
	public Album findAlbumById(int albumId) 
	{
		return manager.find(Album.class, albumId);
	}
}
