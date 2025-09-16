package com.mc.e_game.presentation;

import com.mc.e_game.domain.food.FoodHelper;
import com.mc.e_game.domain.food.FoodPlan;
import com.mc.e_game.domain.item.ItemHelper;
import com.mc.e_game.domain.item.ItemPlan;

public class PrintEffect {

	public static void printItemEffect(String item, int atk, int def) {
		ItemHelper helper = new ItemHelper();
		ItemPlan plan = helper.execute(item, atk, def);
		System.out.println("<"+plan.effect()+">");
		String[] strArr = plan.story().split("\\. ");
		printString(strArr);
    }
    
    public static void printFoodEffect(String item, int hp) {
		FoodHelper helper = new FoodHelper();
		FoodPlan plan = helper.execute(item, hp);
		System.out.println("<"+plan.effect()+">");
		String[] strArr = plan.story().split("\\. ");
		printString(strArr);		
    }
    
    public static void printString(String[] strArr) {
    	StringBuilder sb = new StringBuilder();
		for (String str : strArr) {
			sb.append(str).append(".\n");
		}
		sb.deleteCharAt(sb.lastIndexOf(".\n"));
		System.out.println(sb);
    }
}
