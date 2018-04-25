package com.daldal.springboot.mapper;

import java.util.Map;

public interface MongoMapper {
	public String findTopTen(Map<String, String> map);
}
