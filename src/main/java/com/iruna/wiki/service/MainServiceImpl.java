package com.iruna.wiki.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iruna.wiki.model.mapper.MainMapper;

@Service
public class MainServiceImpl implements MainService{

	@Autowired
	MainMapper mainMapper;

	@Override
	public List<Map<String, Object>> getMenu() throws Exception {
		// TODO Auto-generated method stub
		return mainMapper.getMenu();
	}

	@Override
	public List<Map<String, Object>> getData(String value) {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		switch(value) {
		
		case "pet_guide" :
			break;
		case "swords" :
		case "bows" :
		case "canes" :
		case "claws" :
		case "throwing" :
		case "additional" :
		case "armor" :
		case "special" :
		case "crystas" :
		case "alcrystas" :
		case "reliccrystas" :
			data = mainMapper.getItems(value);
			break;
		default:
			break;
		}
		
		return data;
	}

	@Override
	public String getTitle(String value) {
		return mainMapper.getTitle(value);
	}
	
	
	
}
