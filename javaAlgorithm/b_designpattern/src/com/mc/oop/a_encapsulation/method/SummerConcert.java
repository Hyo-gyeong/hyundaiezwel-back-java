package com.mc.oop.a_encapsulation.method;

import com.mc.oop.a_encapsulation.Player;

public class SummerConcert {
    public void start(){
        System.out.println("Summer Concert 시작합니다~~~~");
        Player player = new Player("바이올린");
        player.play();
        // player.prepare();
        // player.playing();
        // player.stop();
        // player.leave();
        // System.out.println("===================================");
    }
}
