package com.mc.oop.a_encapsulation;

// 객체의 자율성
// 객체가 어떤 작업을 할 떄 그 작업에 대한 책임을 객체에게 주어야 한다
public class Player {
    private String instrument;

    public Player(String instrument){
        super();
        this.instrument = instrument;
    }

    // 코드의 결합도는 떨어지고 유연성이 올라감 - 모든 method를 수정할 필요 없이 Player안 player메서드만 수정하면 됨
    public void play(){
        prepare();
        playing();
        stop();
        leave();
        curtainCall();
    }

    // play에서만 접근 가능하도록 public -> private으로 수정해야 함
    private void prepare(){
        System.out.println(instrument + " 연주를 준비합니다.");
    }

    private void playing(){
        System.out.println(instrument + " 연주를 시작합니다.");
    }

    private void stop(){
        System.out.println("연주를 중단합니다.");
    }

    private void leave(){
        System.out.println("공연장을 떠납니다");
    }

    // 새로운 코드가 추가될 때 수정 및 오류 제거가 어려움
    private void curtainCall(){
        System.out.println("커튼콜을 진행합니다.");
    }
}
