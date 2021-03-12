package com.iruna.wiki.service;

import java.util.List;
import java.util.Map;

public interface MainService {
	public List<Map<String, Object>> getMenu() throws Exception;

	public List<Map<String, Object>> getData(String value);

	public String getTitle(String value);

}
