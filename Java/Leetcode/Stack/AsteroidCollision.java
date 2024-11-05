package com.brianprojects.Leetcode.Stack;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids){
        if(asteroids == null){
            return null;
        }
        Stack<Integer> stack = new Stack<>();

        for(var num: asteroids){
            if(num<0){
                while(!stack.isEmpty() && stack.peek()>0&& Math.abs(num) > stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(num);
                }
                if(!stack.isEmpty() && Math.abs(num) == stack.peek()){
                    stack.pop();
                }
            }
            else{
                stack.push(num);
            }
        }

        int[] res = new int[stack.size()];

        for(var i=res.length-1; i>=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
