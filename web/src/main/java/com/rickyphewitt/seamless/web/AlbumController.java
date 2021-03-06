package com.rickyphewitt.seamless.web;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rickyphewitt.seamless.data.Album;
import com.rickyphewitt.seamless.services.AlbumService;
import com.rickyphewitt.seamless.services.ApiService;
import com.rickyphewitt.seamless.services.ArtistService;
import com.rickyphewitt.seamless.services.FragmentService;
import com.rickyphewitt.seamless.services.SongService;

@Controller
public class AlbumController {

	@Autowired
	ArtistService artistService;
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	SongService songService;
	
	@Autowired
	ApiService loginService;
	
	@Autowired 
	FragmentService fragmentService;
	
	@RequestMapping("/albums")
	public String albums(Model model) {
		
		return fragmentService.getFragment("albums");
	}
	
	@RequestMapping("/album/{id}")
	public String album(@PathVariable("id") String id, Model model) throws InterruptedException, ExecutionException {
		albumService.setCurrentAlbumId(id);
		Album album = albumService.getAlbumsMap().get(id);
		songService.loadSongs(id);
		model.addAttribute("artist", artistService.getArtistsMap().get(artistService.getCurrentArtistId()));
		model.addAttribute("album", album);
		model.addAttribute("songs", songService.getSongs());
		return fragmentService.getFragment("album");
		
		
	}
}
