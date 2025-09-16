package com.mc.e_game.domain.food;

import java.util.Map;

public record FoodPlan(
		String hp,
		String effect,
		String story
		) {

	public static FoodPlan fromMap(Map<String, Object> map) {
		return new FoodPlan((String)map.get("hp"),
				(String)map.get("effect"), 
				(String)map.get("story")
				);
	} 
	
}
