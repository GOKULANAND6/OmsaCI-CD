package com.micro.omsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.omsa.model.Artist;
import com.micro.omsa.repo.ArtistRepo;

@Service
public class ArtistServiceImplementation implements ArtistService
{
	ArtistRepo repo;

	public ArtistServiceImplementation(ArtistRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addArtist(Artist artist) 
	{
		repo.saveArtist(artist);
	}

	@Override
	public List<Artist> getallArtists() 
	{
		return repo.findAllArtists();
	}

	@Override
	public void updateArtist(Artist artist) 
	{
		repo.updateArtist(artist);
	}

	@Override
	public void deleteArtist(int artistId) 
	{
		repo.deleteArtistById(artistId);
	}

	@Override
	public Artist findArtistById(int artistId) 
	{
		return repo.findArtistById(artistId);
	}

	@Override
	public Artist findArtistByName(String artistName) 
	{
		return repo.findArtistByName(artistName);
	}
}
