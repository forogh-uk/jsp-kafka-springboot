package com.bettinggame.jspbettinggame.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bettinggame.jspbettinggame.domain.Bet;


@Repository
public interface BettingRepository extends JpaRepository<Bet, Integer>{
	
	
	public List<Bet> findByclientid(int id);
	
	public List<Bet> findByclientidAndGame(int id, String game);
	
	public List<Bet> findByclientidAndGameAndDate(int id, String game, Date date);

	

}
