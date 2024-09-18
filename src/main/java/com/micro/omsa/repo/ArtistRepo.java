package com.micro.omsa.repo;

import java.util.List;

import com.micro.omsa.model.Artist;

public interface ArtistRepo 
{
	public void saveArtist(Artist artist);

	public List<Artist> findAllArtists();

	public void updateArtist(Artist artist);

	public void deleteArtistById(int artistId);
	
	public Artist findArtistById(int artistId);
		
	public Artist findArtistByName(String artistName);
}
