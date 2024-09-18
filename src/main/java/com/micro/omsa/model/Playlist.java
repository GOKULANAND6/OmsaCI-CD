package com.micro.omsa.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table( name="playlist")
public class Playlist 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int playlistId;
	private String playlistName;
	
	@Lob
	@Column( length = 100000)
	private byte[] playlistImage;
	
	@ManyToOne(targetEntity = UserSignup.class, cascade = CascadeType.MERGE)
	@JoinColumn( name="userId")
	private UserSignup user;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "playlist_song",
        joinColumns = @JoinColumn(name = "playlistId"),
        inverseJoinColumns = @JoinColumn(name = "songId")
    )
    private Set<Song> songs;

	public Playlist() 
	{
		super();
	}

	public Playlist(int playlistId, String playlistName, byte[] playlistImage, UserSignup user, List<Song> songs) {
		super();
		this.playlistId = playlistId;
		this.playlistName = playlistName;
		this.playlistImage = playlistImage;
		this.user = user;
		this.songs = (Set<Song>) songs;
	}

	public int getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public byte[] getPlaylistImage() {
		return playlistImage;
	}

	public void setPlaylistImage(byte[] playlistImage) {
		this.playlistImage = playlistImage;
	}

	public UserSignup getUser() {
		return user;
	}

	public void setUser(UserSignup user) {
		this.user = user;
	}

	public Set<Song> getSongs() {
        return (Set<Song>) songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Playlist [playlistId=" + playlistId + ", playlistName=" + playlistName + ", playlistImage="
                + Arrays.toString(playlistImage) + ", user=" + user + ", songs=" + songs + "]";
    }
}
