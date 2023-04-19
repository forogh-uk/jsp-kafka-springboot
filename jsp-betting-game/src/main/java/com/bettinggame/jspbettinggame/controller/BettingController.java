package com.bettinggame.jspbettinggame.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bettinggame.jspbettinggame.domain.Bet;
import com.bettinggame.jspbettinggame.kafka.JsonKafkaProducer;
import com.bettinggame.jspbettinggame.kafka.KafkaProducer;
import com.bettinggame.jspbettinggame.repository.BettingRepository;
import com.bettinggame.jspbettinggame.service.BettingService;

@Controller

public class BettingController {
	
	@Autowired
	private BettingService bettingService;
	
	@Autowired
	BettingRepository bettingRepo;
	
	@Autowired
	private JsonKafkaProducer kafkaProducer;
	
	


	public BettingController(JsonKafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}

	
	
	@GetMapping("/betting/clientid/id/{id}")
	public ResponseEntity<List<Bet>> getClientId(@PathVariable int id, Bet bet){
		kafkaProducer.sendMessage(bet);
		return new ResponseEntity<>(bettingService.findByClient(id),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/betting/gameandclientidanddate/id/{id}/game/{game}/date/{date}")
	public String getBetByGameAndClientIdAndDate(@PathVariable int id,
													                 @PathVariable String game,
													                 @PathVariable Date date,
													                 Model model,
													                 Bet bet
													                 ){
		model.addAttribute("gameandclientdate", new ResponseEntity<>(bettingService.findByClientAndGameAndDate(id,game,date),HttpStatus.OK));

		kafkaProducer.sendMessage(bet);
		
		return "gameandclientanddate";
	}
	
	
	
	
	
	@GetMapping("/betting/gameandclientid/id/{id}/game/{game}")
	public String getBetByGameAndClientId(@PathVariable int id,
										  @PathVariable String game,
									       Model model,
									       Bet bet
													                 ){
		
		model.addAttribute("gameandclient", new ResponseEntity<>(bettingService.findByClientandgame(id,game),HttpStatus.OK));
		kafkaProducer.sendMessage(bet);
		return "gameandclient";
	}
	
	
	

}
