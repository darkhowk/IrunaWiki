package com.iruna.wiki.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AjaxMapper {
	public List<HashMap<String, Object>> getItemDeatil(String seq);
}
