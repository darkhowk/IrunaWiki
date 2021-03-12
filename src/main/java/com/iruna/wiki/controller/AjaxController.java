package com.iruna.wiki.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iruna.wiki.service.AjaxService;

@RequestMapping(value = "ajax")
@Controller
public class AjaxController {

	@Resource
	private AjaxService ajaxService;
	
	@RequestMapping(value = "getItemDetail")
	public @ResponseBody String getItemDetail(@RequestBody String seq) throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(ajaxService.getItemDeatil(seq));
		return jsonStr;
	}
	
}
