package com.mc.e_game.domain.food;

import com.mc.llm.models.gemini.chat.Format;
import com.mc.llm.models.gemini.chat.code.SchemaType;

//hp, 효과, 스토리
public record FoodPlanFormat(
		SchemaType hp,
		SchemaType effect,
		SchemaType story
		)
implements Format{
	
	public static final FoodPlanFormat INSTANCE = 
			new FoodPlanFormat(SchemaType.STRING
					, SchemaType.STRING
					, SchemaType.STRING);
}
