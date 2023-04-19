package com.bettinggame.jspbettinggame.domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "bet",
indexes = {@Index(name = "index_clientid",  columnList="clientid"),
           @Index(name = "index_date", columnList="date")})
public class Bet {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer id;
	private String game;
	private int numbets;
	private float stake;
	private float returns;

	private Integer clientid;
	private Date date;
	
	public Bet() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Bet(Integer id, String game, int numbets, float stake, float returns, Integer clientid, Date date) {
		super();
		this.id = id;
		this.game = game;
		this.numbets = numbets;
		this.stake = stake;
		this.returns = returns;
		this.clientid = clientid;
		this.date = date;
	}

	
	public Integer getId() {
		return id;
	}

	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public int getNumbets() {
		return numbets;
	}
	public void setNumbets(int numbets) {
		this.numbets = numbets;
	}
	public float getStake() {
		return stake;
	}
	public void setStake(float stake) {
		this.stake = stake;
	}
	public float getReturns() {
		return returns;
	}
	public void setReturns(float returns) {
		this.returns = returns;
	}
	
	
	
	
	public Integer getClientid() {
		return clientid;
	}



	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}



	public void setId(Integer id) {
		this.id = id;
	}











	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Bet [id=" + id + ", game=" + game + ", numbets=" + numbets + ", stake=" + stake + ", returns=" + returns
				+ ", clientid=" + clientid + ", date=" + date + "]";
	}




	

	
	
	
	
	

}
