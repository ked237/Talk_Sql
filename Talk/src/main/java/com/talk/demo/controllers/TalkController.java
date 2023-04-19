package com.talk.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talk.demo.entity.Talk;
import com.talk.demo.services.TalkService;

@RestController
@RequestMapping("/api/v1")
public class TalkController {
	
	@Autowired
	TalkService talkService;
	
	//Get all talks
	@GetMapping("/talks")
	public List<Talk> getAll(){
		return talkService.getTalks();
	}
	//Get one talk 
	
	@GetMapping("/getTalk")
	//we can also use the path /talks 
	//but by providing the id
	public Talk getOneTalk(@RequestParam int id) {
		return talkService.getTalk(id);
	}
	
	@PostMapping("/addTalk")
	public void postTalk(@RequestBody Talk t) {
		//if return talkService you will have the details
		//of your post request sent back to you
		//but since my insert is void, this method has to be 
		//void too
		talkService.insert(t);
	}
	
	@PutMapping("/update")
	public void amendSpeakerAndVenue (@RequestParam int id, @RequestBody Talk t) {
		talkService.update(id, t);
	}
	
	@DeleteMapping("/delete")
	public void deleteTalk(@RequestParam int id) {
		talkService.delete(id);
	}
	
	@GetMapping("/talks/venue")
	public List<Talk> getTalkVenue(@RequestParam String venue) {
		return talkService.getTalksByVenue(venue);
	}
	
	

}
