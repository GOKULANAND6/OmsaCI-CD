package com.micro.omsa.model;

import java.util.Arrays;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table( name="song")
public class Song 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int songId;
	
	@Lob
	@Column(length = 100000)
	private byte[] songImage;
	
	@Lob
	@Column(length = 20000000)
	private byte[] songMp3;
	
	private String songName;
	private String songSinger;
		
	@ManyToOne(targetEntity = Album.class, cascade = CascadeType.MERGE)
	@JoinColumn( name = "albumId")
	private Album album;
	
	public Song() 
	{
		super();
	}

	public Song(int songId, byte[] songImage, byte[] songMp3, String songName, String songSinger, Album album) {
		super();
		this.songId = songId;
		this.songImage = songImage;
		this.songMp3 = songMp3;
		this.songName = songName;
		this.songSinger = songSinger;
		this.album = album;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public byte[] getSongImage() {
		return songImage;
	}

	public void setSongImage(byte[] songImage) {
		this.songImage = songImage;
	}

	public byte[] getSongMp3() {
		return songMp3;
	}

	public void setSongMp3(byte[] songMp3) {
		this.songMp3 = songMp3;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongSinger() {
		return songSinger;
	}

	public void setSongSinger(String songSinger) {
		this.songSinger = songSinger;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songImage=" + Arrays.toString(songImage) + ", songMp3="
				+ Arrays.toString(songMp3) + ", songName=" + songName + ", songSinger=" + songSinger + ", album="
				+ album + "]";
	}
}
