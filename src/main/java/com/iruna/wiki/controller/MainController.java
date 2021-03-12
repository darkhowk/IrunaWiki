package com.iruna.wiki.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iruna.wiki.service.MainService;

@RestController
public class MainController {

	@Resource
	private MainService mainService;

	@RequestMapping(value = { "**/favicon.ico", "favicon.ico" })
	public String favicon() {
		return "forward:/resources/favicon.ico";
	}

	// 메뉴별 
	@RequestMapping(value = {"stats", "skills", "abilities", "abilities_beta", "apostolia", "class", "background_music", "lottery", "pet_guide", "quests", "refinement", "raids" })
	public ModelAndView guide(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<Map<String, Object>> menu = mainService.getMenu();

		HttpSession session = request.getSession();

		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(menu);

		session.setAttribute("menu", jsonStr);

		String value = request.getServletPath().toLowerCase().replace("/", "");

		List<Map<String, Object>> data = mainService.getData(value);
		String jsonData = mapper.writeValueAsString(data);
		String title = mainService.getTitle(value);

		mav.addObject("data", jsonData);
		mav.addObject("title", title);

		mav.addObject("content", "guide/"+value);
		mav.addObject("view", "guide");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value = {"halloween","summer" ,"white_day" ,"easter", "valentines_day", "setsubun", "christmas", "academy", "anniversary"})
	public ModelAndView event(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<Map<String, Object>> menu = mainService.getMenu();

		HttpSession session = request.getSession();

		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(menu);

		session.setAttribute("menu", jsonStr);

		String value = request.getServletPath().toLowerCase().replace("/", "");

		List<Map<String, Object>> data = mainService.getData(value);
		String jsonData = mapper.writeValueAsString(data);
		String title = mainService.getTitle(value);

		mav.addObject("data", jsonData);
		mav.addObject("title", title);

		mav.addObject("view", "event");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value = {"ep1","ep2" ,"ep3" ,"ep4", "ep5", "ep6", "map_raids", "map_events"})
	public ModelAndView map(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<Map<String, Object>> menu = mainService.getMenu();

		HttpSession session = request.getSession();

		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(menu);

		session.setAttribute("menu", jsonStr);

		String value = request.getServletPath().toLowerCase().replace("/", "");

		List<Map<String, Object>> data = mainService.getData(value);
		String jsonData = mapper.writeValueAsString(data);
		String title = mainService.getTitle(value);

		mav.addObject("data", jsonData);
		mav.addObject("title", title);

		mav.addObject("view", "map");
		mav.setViewName("main");
		return mav;
	}

	@RequestMapping(value = { "item_status", "strenghening", "teleport", "item_skill", "chests", "collectibles", "ores", "island_objects", "store_items", "pets", "other", "recovery" })
	public ModelAndView item(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> menu = mainService.getMenu();

		HttpSession session = request.getSession();

		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(menu);

		session.setAttribute("menu", jsonStr);

		String value = request.getServletPath().toLowerCase().replace("/", "");

		List<Map<String, Object>> data = mainService.getData(value);
		String jsonData = mapper.writeValueAsString(data);

		String title = mainService.getTitle(value);
		mav.addObject("data", jsonData);
		mav.addObject("title", title);

		mav.addObject("view", "item");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value = { "swords", "bows", "canes", "claws", "throwing", "armor", "additional", "special", "crystas", "alcrystas", "reliccrystas" })
	public ModelAndView equipment(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> menu = mainService.getMenu();

		HttpSession session = request.getSession();

		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(menu);

		session.setAttribute("menu", jsonStr);

		String value = request.getServletPath().toLowerCase().replace("/", "");

		List<Map<String, Object>> data = mainService.getData(value);
		String jsonData = mapper.writeValueAsString(data);

		String title = mainService.getTitle(value);
		mav.addObject("data", jsonData);
		mav.addObject("title", title);

		mav.addObject("view", "equipment");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value = { "cooking", "alchemy", "chasing", "tailoring", "carpentry", "smiting", "calculator" })
	public ModelAndView production(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> menu = mainService.getMenu();

		HttpSession session = request.getSession();

		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(menu);

		session.setAttribute("menu", jsonStr);

		String value = request.getServletPath().toLowerCase().replace("/", "");

		List<Map<String, Object>> data = mainService.getData(value);
		String jsonData = mapper.writeValueAsString(data);

		String title = mainService.getTitle(value);
		mav.addObject("data", jsonData);
		mav.addObject("title", title);

		mav.addObject("view", "production");
		mav.setViewName("main");
		return mav;
	}
	
	
	@RequestMapping(value = { "/", "main", "base" })
	public ModelAndView main(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<Map<String, Object>> menu = mainService.getMenu();

		HttpSession session = request.getSession();

		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(menu);

		session.setAttribute("menu", jsonStr);

		mav.addObject("view", "base");
		mav.setViewName("main");
		return mav;
	}

}
