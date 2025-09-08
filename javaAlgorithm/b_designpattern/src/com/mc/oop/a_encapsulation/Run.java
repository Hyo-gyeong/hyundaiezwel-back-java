package com.mc.oop.a_encapsulation;

import com.mc.oop.a_encapsulation.method.FallConcert;
import com.mc.oop.a_encapsulation.method.SpringConcert;
import com.mc.oop.a_encapsulation.method.SummerConcert;
import com.mc.oop.a_encapsulation.method.WinterConcert;

public class Run {
    public static void main(String[] args) {
        // 결합도는 높고 응집도는 낮은 프로그래밍
        SpringConcert spring = new SpringConcert();
        spring.start();
        SummerConcert summer = new SummerConcert();
        summer.start();
        FallConcert fall = new FallConcert();
        fall.start();
        WinterConcert winter = new WinterConcert();
        winter.start();
    }
}
