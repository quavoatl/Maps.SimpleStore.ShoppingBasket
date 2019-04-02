package com.example;

import java.util.Collections;

import java.util.Map;
import java.util.TreeMap;

public class ShoppingBasket {

    private final String name;
    private final Map<StockItem, Integer> list;

    public ShoppingBasket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            int inBasket = list.getOrDefault(item,0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> items() {
        return Collections.unmodifiableMap(list);
    }


    public int buyItem(ShoppingBasket basket,StockList stockList, String item, int quantity) {
        StockItem stockItem = stockList.getItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        } else
            System.out.println("You can buy only " + (stockList.getItem(item).quantityInStock())
                    + " " + (stockList.getItem(item).quantityInStock() == 1 ? item : item+"s") );
        return -1;
    }


    @Override
    public String toString() {
        String s = "\nShopping basket\n" + name + " contains " + list.size() + ((list.size() == 1 ? " item" : " items")+"\n");
        double totalCost = 0.0;
        for(Map.Entry<StockItem,Integer> item : list.entrySet()){
            s = s + item.getKey() + ". Purchased : " + item.getValue() + " "+
                    (item.getValue() == 1 ? item.getKey().getName() : item.getKey().getName()+"s")
                    + ". Total cost : " + item.getKey().getPrice() * item.getValue()+ "\n";
            totalCost = totalCost+ item.getKey().getPrice() * item.getValue();
        }
        return s + " grand total " + totalCost;
    }
}
