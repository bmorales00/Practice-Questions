package com.brianprojects.Leetcode.Greedy;

import java.util.ArrayDeque;

public class Dota2Senate {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public String predictPartVictory(String senate){
        if(senate.isEmpty()){return "";}
        ArrayDeque<Integer> rQueue = new ArrayDeque<>();
        ArrayDeque<Integer> dQueue = new ArrayDeque<>();
        int n = senate.length();
        for(var i = 0; i<senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                rQueue.add(i);
            }
            else{
                dQueue.add(i);
            }
        }
        while(!rQueue.isEmpty() && !dQueue.isEmpty()){
            if(rQueue.peek() < dQueue.peek()){
                dQueue.removeFirst();
                int val = n+rQueue.removeFirst();
                rQueue.add(val);
            }
            else{
                rQueue.removeFirst();
                int val = n+dQueue.removeFirst();
                dQueue.add(val);
            }
        }

        return rQueue.isEmpty()?"Dire":"Radiant";
    }
    public String predictPartVictory2(String senate){
        if(senate.isEmpty()){return "";}
        char[] ch = senate.toCharArray();
        int r = 0, d = 0;
        for(char c: ch){
            if(c=='R'){
                r++;
            }
            else{d++;}
        }
        int n = ch.length;
        int r_left = 0;
        int d_left = 0;
        while(r>0 && d>0){
            int i =0;
            int j =0;
            while(i<n){
                if(ch[i] == 'R'){
                    if(r_left>0){
                        r_left--;
                        r--;
                    }
                    else{
                        ch[j++]='R';
                        d_left++;
                    }
                }
                else{
                    if(d_left>0){
                        d_left--;
                        d--;
                    }
                    else{
                        ch[j++]='D';
                        r_left++;
                    }
                }
                i++;
            }
            n=j;
        }
        return r>0?"Radiant":"Dire";
    }
}
