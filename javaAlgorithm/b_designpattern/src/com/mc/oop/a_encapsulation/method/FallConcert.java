package com.mc.oop.a_encapsulation.method;

import com.mc.oop.a_encapsulation.Player;

public class FallConcert {
    public void start(){
        System.out.println("Fall Concert 시작합니다~~~~");
        Player player = new Player("바이올린");
        player.play();
        // player.prepare();
        // player.playing();
        // player.stop();
        // player.leave();
        // System.out.println("===================================");
    }
}
