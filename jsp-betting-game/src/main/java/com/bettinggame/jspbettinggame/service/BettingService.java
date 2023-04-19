package com.bettinggame.jspbettinggame.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bettinggame.jspbettinggame.domain.Bet;
import com.bettinggame.jspbettinggame.repository.BettingRepository;

@Service
public class BettingService {
	
	@Autowired
	private BettingRepository bettingRepository;
	
	//to find list of bets
	
	public Iterable<Bet> findAll(){
		return bettingRepository.findAll();
		
	}
	
	public List<Bet> findByClient(int id) {
		
		return bettingRepository.findByclientid(id);
	}
	
	
	public List<Bet> findByClientAndGameAndDate(int id, String name, Date date) {
		return bettingRepository.findByclientidAndGameAndDate(id, name, date);
	}
	
	public List<Bet> findByClientandgame(int id, String game) {
		return bettingRepository.findByclientidAndGame(id, game);
	}
	
	
	
	
	//save metod to take list of bet

	public Iterable<Bet> save(List<Bet> bet) {
		return bettingRepository.saveAll(bet);
		
	}

}
