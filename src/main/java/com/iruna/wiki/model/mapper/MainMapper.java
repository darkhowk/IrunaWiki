package com.iruna.wiki.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {
	public List<Map<String, Object>> getMenu() throws Exception;

	public List<Map<String, Object>> getPetGuide();

	public List<Map<String, Object>> getItems(String value);

	public String getTitle(String value);
}
