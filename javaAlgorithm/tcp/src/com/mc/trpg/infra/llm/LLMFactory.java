package com.mc.trpg.infra.llm;

import java.util.HashMap;
import java.util.Map;

import com.mc.llm.models.BaseModel;
import com.mc.llm.models.LLMContext;
import com.mc.llm.models.LLMProvider;

public class LLMFactory {
	
	public static LLMFactory INSTANCE;
	private Map<LLMProvider, BaseModel> modelMap;
	private final String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";
	
	public static LLMFactory getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new LLMFactory();
		}
		
		return INSTANCE;
	}
	
	public LLMFactory() {
		LLMContext context = new LLMContext();
		modelMap = new HashMap<>();
		modelMap.put(LLMProvider.GEMINI, context.initChatModel(GEMINI_API_URL, LLMProvider.GEMINI));
	}
	
	public BaseModel create(LLMProvider provider) {
		return modelMap.get(provider);
	}

}
