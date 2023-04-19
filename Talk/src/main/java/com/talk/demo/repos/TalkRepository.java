package com.talk.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talk.demo.entity.Talk;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Integer> {
	
	List <Talk> findByVenue (String venue);
}
