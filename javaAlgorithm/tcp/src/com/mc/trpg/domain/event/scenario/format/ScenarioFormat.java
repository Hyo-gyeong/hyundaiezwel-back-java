package com.mc.trpg.domain.event.scenario.format;

import java.util.Map;

import com.mc.llm.models.gemini.chat.Format;
import com.mc.llm.models.gemini.chat.code.SchemaType;
import com.mc.trpg.domain.event.scenario.dto.ScenarioDto;

public record ScenarioFormat(
		SchemaType scenario
		) implements Format {

	public static final ScenarioFormat format = 
			new ScenarioFormat(SchemaType.STRING);
	
	
}
