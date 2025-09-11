package com.mc.coffeemanager.domain.discount.condition;

import com.mc.coffeemanager.domain.order.Order;

public class OrderPriceCondition implements DiscountCondition{

    private final int min;
    private final int max;
    
    public OrderPriceCondition(int min, int max) {
        if (min < 0 || max < 0 || max < min){
            throw new IllegalArgumentException("max, min값의 범위를 확인하세요");
        }
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isSatisfied(Order order) {
        return order.getOrderPrice() >= min && order.getOrderPrice() < max;
    }
    
}
