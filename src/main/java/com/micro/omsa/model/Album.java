package com.micro.omsa.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table( name="album")
public class Album 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int albumId;
	
	@Lob
	@Column(length = 100000)
	private byte[] albumImage;
	
	private String albumLanguage;
	private String albumName;
	private String musicDirector;
	
	public Album() 
	{
		super();
	}

	public Album(int albumId, byte[] albumImage, String albumLanguage, String albumName, String musicDirector) {
		super();
		this.albumId = albumId;
		this.albumImage = albumImage;
		this.albumLanguage = albumLanguage;
		this.albumName = albumName;
		this.musicDirector = musicDirector;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public byte[] getAlbumImage() {
		return albumImage;
	}

	public void setAlbumImage(byte[] albumImage) {
		this.albumImage = albumImage;
	}

	public String getAlbumLanguage() {
		return albumLanguage;
	}

	public void setAlbumLanguage(String albumLanguage) {
		this.albumLanguage = albumLanguage;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getMusicDirector() {
		return musicDirector;
	}

	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}

	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", albumImage=" + Arrays.toString(albumImage) + ", albumLanguage="
				+ albumLanguage + ", albumName=" + albumName + ", musicDirector=" + musicDirector + "]";
	}
}
