package com.example;

public class Main {

    public static void main(String[] args) {
        StockList stockList = new StockList();
        StockItem temp = new StockItem("bread", 0.80, 100);
        stockList.addItem(temp);

        temp = new StockItem("egg", 0.20, 100);
        stockList.addItem(temp);

        temp = new StockItem("water bottle", 0.70, 200);
        stockList.addItem(temp);

        temp = new StockItem("salt bag", 1, 50);
        stockList.addItem(temp);

        temp = new StockItem("flour bag", 1.20, 20);
        stockList.addItem(temp);

        System.out.println(stockList);

        ShoppingBasket basket = new ShoppingBasket("Shopping Basket");

        basket.buyItem(basket,stockList,"salt bag", 1);
        System.out.println(basket);

        basket.buyItem(basket,stockList, "water bottle", 10);
        basket.buyItem(basket,stockList, "egg", 10);
        basket.buyItem(basket,stockList, "juice", 20);
        basket.buyItem(basket,stockList, "egg", 92);

        System.out.println(basket);
    }


}
