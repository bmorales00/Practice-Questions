package com.brianprojects.HackerRank;

public class Stairs {
    public void printStairs(int n){
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, n)));
        for(int i = n-1; i>=0;i--){
            sb.replace(i,i+1, "#");
            System.out.println(sb);
        }
    }
}
