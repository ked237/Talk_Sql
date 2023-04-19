package com.talk.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.talk.demo.entity.Talk;

public interface TalkRepository extends MongoRepository<Talk, Integer> {
	 
	List <Talk> findByVenue (String venue);

}
