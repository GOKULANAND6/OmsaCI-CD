package com.micro.omsa.service;

import java.util.List;

import com.micro.omsa.model.Artist;


public interface ArtistService 
{
	public void addArtist(Artist artist);
	 
	public List<Artist> getallArtists();

	public void updateArtist(Artist artist);

	public void deleteArtist(int artistId);
	
	public Artist findArtistById(int artistId);
		
	public Artist findArtistByName(String artistName);
}
