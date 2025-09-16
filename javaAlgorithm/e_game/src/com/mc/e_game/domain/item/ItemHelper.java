package com.mc.e_game.domain.item;

import java.util.List;
import java.util.Map;

import com.mc.llm.models.BaseModel;
import com.mc.llm.models.BaseRequest;
import com.mc.llm.models.BaseResponse;
import com.mc.llm.models.LLMContext;
import com.mc.llm.models.LLMProvider;
import com.mc.llm.models.gemini.chat.GeminiRequest;

public class ItemHelper {

	private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";
	
	private BaseModel model = new LLMContext()
			.initChatModel(API_URL, LLMProvider.GEMINI);
	
	public ItemHelper() {
		// TODO Auto-generated constructor stub
	}

	public ItemPlan execute(String item, int atk, int def) {
		String str = "모험을 떠나는 길에 "+ item+" 아이템을 얻어서 공격력이 "+atk+"만큼 증가하고 방어력이"+def+"만큼 증가해서 앞으로 떠날 모험에 큰 도움이 된다는 게임 배경 스토리를 한글로 짜줘."
				+"아이템이 효과적이라는 느낌도 넣어줘.";
		BaseRequest req = new GeminiRequest<ItemPlanFormat>(str, ItemPlanFormat.INSTANCE);
		BaseResponse resp = model.invoke(req);
		List<Map<String, Object>> res = resp.messageToMap();
		return ItemPlan.fromMap(res.getFirst());
	}

}
