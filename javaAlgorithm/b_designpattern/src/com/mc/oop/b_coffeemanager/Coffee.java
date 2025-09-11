package com.mc.oop.b_coffeemanager;

public class Coffee {
    private String names;
    private int prices;
    private int costs;
    private int stocks;
    private int safetyStocks;
    private int salesCnt;

    public Coffee(String names, int prices, int costs, int stocks, int safetyStocks, int salesCnt) {
        this.names = names;
        this.prices = prices;
        this.costs = costs;
        this.stocks = stocks;
        this.safetyStocks = safetyStocks;
        this.salesCnt = salesCnt;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public void setSafetyStocks(int safetyStocks) {
        this.safetyStocks = safetyStocks;
    }

    public void setSalesCnt(int salesCnt) {
        this.salesCnt = salesCnt;
    }

    public String getNames() {
        return names;
    }

    public int getPrices() {
        return prices;
    }

    public int getCosts() {
        return costs;
    }

    public int getStocks() {
        return stocks;
    }

    public int getSafetyStocks() {
        return safetyStocks;
    }

    public int getSalesCnt() {
        return salesCnt;
    }

    public void deductStock(int stocks){
        this.stocks -= stocks;
    }

    public void addStock(int stocks){
        this.stocks += stocks;
    }

    

        
}
