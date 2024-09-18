package com.micro.omsa.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.omsa.model.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ArtistRepoImplementation implements ArtistRepo
{
	EntityManager manager;
	
	public ArtistRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void saveArtist(Artist artist) 
	{
		manager.persist(artist);
	}

	@Override
	public List<Artist> findAllArtists() 
	{
		String str = "From Artist";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void updateArtist(Artist artist) 
	{
		manager.merge(artist);
	}

	@Override
	public void deleteArtistById(int artistId) 
	{
		Artist artist = manager.find(Artist.class, artistId);
		manager.remove(artist);
	}

	@Override
	public Artist findArtistById(int artistId) 
	{
		return manager.find(Artist.class, artistId);
	}

	@Override
	public Artist findArtistByName(String artistName) 
	{
		String str = "From Artist where artistName=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", artistName);
		return (Artist) query.getSingleResult();
	}
}
