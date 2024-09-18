package com.micro.omsa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.micro.omsa.model.Album;
import com.micro.omsa.service.AlbumServiceImplementation;

@RestController
@RequestMapping("/album")
@CrossOrigin(origins = "http://localhost:3000")
public class AlbumController 
{
	AlbumServiceImplementation service;

	public AlbumController(AlbumServiceImplementation service) {
		super();
		this.service = service;
	}

	@PostMapping
    public ResponseEntity<String> insertAlbum(
            @RequestParam("albumImage") MultipartFile albumImage,
            @RequestParam("albumLanguage") String albumLanguage,
            @RequestParam("albumName") String albumName,
            @RequestParam("musicDirector") String musicDirector){

        try {
            Album album = new Album();

            if (albumImage != null && !albumImage.isEmpty()) {
                album.setAlbumImage(albumImage.getBytes());
            }
            
            album.setAlbumLanguage(albumLanguage);
            album.setAlbumName(albumName);
            album.setMusicDirector(musicDirector);

            service.addAlbum(album);

            return ResponseEntity.ok("Album Added successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in adding album.");
        }
    }

	@GetMapping("/all")
	public List<Album> readAllAlbums()
	{
	return service.getallAlbums();
	}

	@PutMapping
	public  String updateAlbum(@RequestBody Album album)
	{
	String msg = "";
	try {
	service.updateAlbum(album);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{albumId}")
	public String deleteAlbumbyId(@PathVariable("albumId") int albumId)
	{
	String msg = "";
	try {
	service.deleteAlbum(albumId);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
	@GetMapping("{albumName}")
	public Album findAlbum(@PathVariable("albumName") String albumName)
	{
			return service.findAlbumByName(albumName);
	}
	
	@GetMapping("{albumId}")
	public Album findAdmin(@PathVariable("albumId") int albumId)
	{
			return service.findAlbumById(albumId);
	}
}
