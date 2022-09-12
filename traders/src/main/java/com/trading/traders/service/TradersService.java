package com.trading.traders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trading.traders.model.TradersModel;
import com.trading.traders.repository.TradersRepo;

import java.util.List;

@Service
public class TradersService {
	
	@Autowired
	private TradersRepo traders;
	
	public ResponseEntity<Boolean> createTraderService(TradersModel trader) {
		// TODO Auto-generated method stub
//		System.out.println(trader.getEmail());
		System.out.println(traders.checkName(trader.getEmail()));
		if(traders.checkName(trader.getEmail())==null) {
			traders.save(trader);
			return new ResponseEntity<>(Boolean.valueOf(true),HttpStatus.CREATED);
		}
		return new ResponseEntity<>(Boolean.valueOf(false),HttpStatus.BAD_REQUEST);
	}

	public List<TradersModel> getAllTradersService() {
		// TODO Auto-generated method stub
//		System.out.println(traders.findAll());
//		return (List) traders.findAll();
		
		return traders.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public ResponseEntity<List<TradersModel>> getRecordByEmail(String email) {
//		 TODO Auto-generated method stub
		if(traders.getRecordByEmail(email).size()==0) {
			return new ResponseEntity<>(traders.getRecordByEmail(email),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(traders.getRecordByEmail(email),HttpStatus.OK);
//		return traders.getRecordByEmail(email);
	}

	public ResponseEntity<Boolean> updatetraderservice(TradersModel trader) {
		// TODO Auto-generated method stub
	if(traders.checkUpdated(trader.getName(),trader.getEmail())==0) {
		return new ResponseEntity<>(Boolean.valueOf(false),HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(Boolean.valueOf(true),HttpStatus.OK);
	}
//
	public ResponseEntity<Boolean> addmoneyservice(TradersModel trader) {
		// TODO Auto-generated method stub
		if(traders.addAmount(trader.getBalance(), trader.getEmail())==0) {
			return new ResponseEntity<>(Boolean.valueOf(false),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(Boolean.valueOf(true),HttpStatus.OK);
	}

}
