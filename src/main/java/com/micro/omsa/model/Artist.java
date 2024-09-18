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
@Table( name="artist")
public class Artist 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int artistId;
	private String artistName;
	
	@Lob
	@Column( length = 100000)
	private byte[] artistImage;
	
	private String dob;
	private String bio;
	private String specialization;
	
	public Artist() 
	{
		super();
	}

	public Artist(int artistId, String artistName, byte[] artistImage, String dob, String bio, String specialization) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
		this.artistImage = artistImage;
		this.dob = dob;
		this.bio = bio;
		this.specialization = specialization;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public byte[] getArtistImage() {
		return artistImage;
	}

	public void setArtistImage(byte[] artistImage) {
		this.artistImage = artistImage;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + ", artistImage="
				+ Arrays.toString(artistImage) + ", dob=" + dob + ", bio=" + bio + ", specialization=" + specialization
				+ "]";
	}
}
