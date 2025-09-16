package com.mc.e_game.domain.item;

import java.util.Map;

public record ItemPlan(
		String atk,
		String def,
		String effect,
		String story
		) {

	public static ItemPlan fromMap(Map<String, Object> map) {
		return new ItemPlan((String)map.get("atk"),
				(String)map.get("def"), 
				(String)map.get("effect"),
				(String)map.get("story")
				);
	} 
	
}
