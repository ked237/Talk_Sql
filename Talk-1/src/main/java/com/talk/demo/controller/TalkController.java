package com.talk.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talk.demo.entity.Talk;
import com.talk.demo.service.TalkService;

@RestController
public class TalkController {
	
	@Autowired
	TalkService talkService;
	
		//Get all talks
		@GetMapping("/talks")
		public List<Talk> getTalks(){
			return talkService.getTalks();
		}
		//Get one talk by Id
		@GetMapping("/talks/{id}")
		public Talk getTalk (@PathVariable int id) {
			return talkService.getTalk(id);
		}
		@PostMapping("/addTalk")
		public String addTalk(@RequestBody Talk t) {
			talkService.insert(t);
			
			return "Added Sucessfully";
		}
		@DeleteMapping("/deleteTalk/{id}")
		public String removeById (@PathVariable int id) {
			talkService.delete(id);
			return "Successfully Deleted";
		}
		@GetMapping("/{venue}")
		public List<Talk> getTalkVenue(@PathVariable String venue) {
			return talkService.getVenue(venue);
		}
		@PutMapping("/updateTalk/{id}")
		public void amendSpeakerAndVenue (@PathVariable int id, @RequestBody Talk t) {
			talkService.update(id, t);
		}
		
	

}
