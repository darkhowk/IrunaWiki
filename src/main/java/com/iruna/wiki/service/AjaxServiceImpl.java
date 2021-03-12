package com.iruna.wiki.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iruna.wiki.model.mapper.AjaxMapper;

@Service
public class AjaxServiceImpl implements AjaxService{

	@Autowired
	AjaxMapper ajaxMapper;

	@Override
	public List<HashMap<String, Object>> getItemDeatil(String seq) {
		return ajaxMapper.getItemDeatil(seq);
	}
	
	
}
