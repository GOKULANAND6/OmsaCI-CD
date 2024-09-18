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

import com.micro.omsa.model.Artist;
import com.micro.omsa.service.ArtistServiceImplementation;

@RestController
@RequestMapping("/artist")
@CrossOrigin( origins = "http://localhost:3000")
public class ArtistController 
{	
	ArtistServiceImplementation service;

	public ArtistController(ArtistServiceImplementation service) {
		super();
		this.service = service;
	}
	
	@PostMapping
    public ResponseEntity<String> inserArtist(
            @RequestParam("artistImage") MultipartFile artistImage,
            @RequestParam("artistName") String artistName,
            @RequestParam("dob") String dob,
            @RequestParam("bio") String bio,
            @RequestParam("specialization") String specialization){

        try {
            Artist artist = new Artist();

            if (artistImage != null && !artistImage.isEmpty()) {
                artist.setArtistImage(artistImage.getBytes());
            }
            
            artist.setArtistName(artistName);
            artist.setDob(dob);
            artist.setBio(bio);
            artist.setSpecialization(specialization);

            service.addArtist(artist);

            return ResponseEntity.ok("Artist Added successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in adding artist.");
        }
    }

	@GetMapping("/all")
	public List<Artist> readAllArtists()
	{
	return service.getallArtists();
	}

	@PutMapping
	public  String updateArtist(@RequestBody Artist artist)
	{
	String msg = "";
	try {
	service.updateArtist(artist);
	msg = "Successfully Updated";
	}
	catch (Exception e) {
	msg = "Failed to Update";
	}
	return msg;
	}

	@DeleteMapping("{artistId}")
	public String deleteArtistbyId(@PathVariable("artistId") int artistId)
	{
	String msg = "";
	try {
	service.deleteArtist(artistId);
	msg = "Successfully Deleted";
	}
	catch (Exception e) {
	msg = "Failed to Delete";
	}
	return msg;	
	}
	
    @GetMapping("/name/{artistName}")
    public Artist findArtistByName(@PathVariable("artistName") String artistName) {
        return service.findArtistByName(artistName);
    }

    @GetMapping("/{artistId}")
    public Artist findArtistById(@PathVariable("artistId") int artistId) {
        return service.findArtistById(artistId);
    }
}
