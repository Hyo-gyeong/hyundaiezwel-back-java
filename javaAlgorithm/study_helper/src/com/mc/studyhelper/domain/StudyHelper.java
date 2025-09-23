package com.mc.studyhelper.domain;

import java.util.List;
import java.util.Map;

import com.mc.llm.models.BaseModel;
import com.mc.llm.models.BaseRequest;
import com.mc.llm.models.BaseResponse;
import com.mc.llm.models.LLMContext;
import com.mc.llm.models.LLMProvider;
import com.mc.llm.models.gemini.chat.GeminiRequest;

public class StudyHelper {

	private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";
	
	private BaseModel model = new LLMContext()
			.initChatModel(API_URL, LLMProvider.GEMINI);
	
	public StudyHelper() {
		// TODO Auto-generated constructor stub
	}

	public StudyPlan execute(String inp) {
		inp += ".  이 프로그래밍 언어의 난이도, 미리 학습하면 좋은 프로그래밍 언어, "
				+ "학습 소요기간, 학습 후 하면 좋은 프로젝트 아이디어를 추천해줘. 한글로 말해줘.";
		BaseRequest req = new GeminiRequest<StudyPlanFormat>(inp, StudyPlanFormat.INSTANCE);
		BaseResponse resp = model.invoke(req);
		List<Map<String, Object>> res = resp.messageToMap();
		System.out.println(res);
		return StudyPlan.fromMap(res.getFirst());
	}

}
