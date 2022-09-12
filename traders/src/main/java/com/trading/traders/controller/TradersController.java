package com.trading.traders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trading.traders.model.TradersModel;
import com.trading.traders.service.TradersService;

import java.util.List;

@RestController
public class TradersController {
	
	@Autowired
	private TradersService traderservice;
	
	@PostMapping(path="/trading/traders/register")
	public ResponseEntity<Boolean> createTrader(@RequestBody TradersModel trader) {
		return traderservice.createTraderService(trader);
	}
	
	@GetMapping(path="trading/traders/all")
	public ResponseEntity<List<TradersModel>> getAllTraders(){
		return new ResponseEntity<>(traderservice.getAllTradersService(),HttpStatus.OK);
	}
	
	@GetMapping(path="/trading/traders/{email}")
	public ResponseEntity<List<TradersModel>> getAllTraders(@PathVariable("email") String email){
		return traderservice.getRecordByEmail(email);
	}
////	
	@PutMapping(path="/trading/traders")
	public ResponseEntity<Boolean> updateTrader(@RequestBody TradersModel trader) {
		return traderservice.updatetraderservice(trader);
	}
//	
	@PutMapping(path="/trading/traders/add")
	public ResponseEntity<Boolean> AddMoney(@RequestBody TradersModel trader) {
		return traderservice.addmoneyservice(trader);
	}
	
	
	
}
