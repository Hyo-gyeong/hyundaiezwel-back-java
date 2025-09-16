package com.mc.e_game.domain.item;

import com.mc.llm.models.gemini.chat.Format;
import com.mc.llm.models.gemini.chat.code.SchemaType;

// 공격력, 방어력, 효과, 스토리
public record ItemPlanFormat(
		SchemaType atk,
		SchemaType def,
		SchemaType effect,
		SchemaType story
		)
implements Format{
	
	public static final ItemPlanFormat INSTANCE = 
			new ItemPlanFormat(SchemaType.STRING
					, SchemaType.STRING
					, SchemaType.STRING
					, SchemaType.STRING);
}
