package com.mc.coffeemanager.domain.multilingual.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public class UsaDecorator extends PaymentDecorator{

    public UsaDecorator(Translatable<Payment> target) {
        super(target);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String translate() {
        String info = target.translate();
        Payment payment = origin();
        
        // 디미터의 법칙 : 한 줄에 .을 하나만 찍어라 - 객체의 내부 속성에 대해 몰라야 한다
        // 도메인 객체일 경우에만 해당됨
        // DTO, VO, 자료구조
        info += payment.getOrderName()+" cup\n"+
                payment.getPaymentPrice()/1300 + " dollars";
        return info;
    }
    
    @Override
    public Payment origin() {
        return target.origin();
    }
    
}
