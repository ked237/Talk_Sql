package com.talk.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talk.demo.entity.Talk;
import com.talk.demo.exceptions.RessourceNotFoundException;
import com.talk.demo.repository.TalkRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TalkService {
		
		@Autowired
		TalkRepository talkRepo;
		
		public List<Talk> getTalks(){
			return talkRepo.findAll();
		}
		
		public void insert (Talk t) {
			talkRepo.save(t);
		}
		
		public Talk getTalk(int id) {
			return talkRepo.findById(id).get();
		}
		
		public void update (int id, Talk t) {
			Optional<Talk> optionalTalk = talkRepo.findById(id);
			if (optionalTalk.isPresent()) {
				Talk talk = optionalTalk.get();
				talk.setVenue(t.getVenue());
				talk.setSpeaker(t.getSpeaker());
				talkRepo.save(talk);
			}
			else {
				throw new RessourceNotFoundException ("No such talk found");
			}
		}
		
		public void delete (int id) {
			Optional <Talk> optionalTalk = talkRepo.findById(id);
			if(optionalTalk.isPresent()) {
				talkRepo.deleteById(id);
			}
			else {
				throw new RessourceNotFoundException("No talk with this Id");
			}
		}
		
		public List<Talk> getVenue (String v) {
			return talkRepo.findByVenue(v);
		}


}
