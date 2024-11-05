package com.brianprojects.Leetcode.Stack;

import java.util.Stack;

public class OnlineStockSpan {
    //Space Complexity: O(n)
    private class StockItem{
        private int spanDays;
        private int stockPrice;

        public StockItem(int stockPrice,int spanDays ) {
            this.stockPrice = stockPrice;
            this.spanDays = spanDays;
        }

        public int getSpanDays() {
            return spanDays;
        }

        public int getStockPrice() {
            return stockPrice;
        }
    }

    Stack<StockItem> stack;
    public OnlineStockSpan() {
        this.stack = new Stack<>();
    }
    // Time Complexity: O(n)
    public int next(int price){
        if(price <=0){
            throw new IllegalArgumentException();
        }
        int span = 1;
        if(stack.isEmpty()){
            stack.push(new StockItem(price, span));
            return stack.peek().getSpanDays();
        }
        while(!stack.isEmpty() && price >= stack.peek().getStockPrice()){
            span+=stack.pop().getSpanDays();
        }
        stack.push(new StockItem(price, span));
        return stack.peek().getSpanDays();
    }
}
