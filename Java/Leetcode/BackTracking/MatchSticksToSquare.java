package com.brianprojects.Leetcode.BackTracking;

import java.util.Arrays;

public class MatchSticksToSquare {
    //Time Complexity: O(n log n)+O(4^n) = O(4^n) ||Space Complexity: O(1)
    public boolean makesquare(int[] matchsticks){
        int total = 0;
        for(int val:matchsticks){
            total+=val;
        }
        if(total%4 != 0){return false;}
        Arrays.sort(matchsticks);
        return canmakesquare(matchsticks, new int[4],total/4,matchsticks.length-1);
    }

    private boolean canmakesquare(int[] matchsticks, int[] sticks,int maxStickSize, int index) {
        if(index == -1){
            return sticks[0] == maxStickSize && sticks[1] == maxStickSize && sticks[2] == maxStickSize && sticks[3] == maxStickSize;
        }
        for(int i = 0; i< sticks.length; i++){
            if(sticks[i] + matchsticks[index]>maxStickSize){continue;}
            sticks[i]+=matchsticks[index];
            if(canmakesquare(matchsticks,sticks,maxStickSize,index-1)){return true;}
            sticks[i]-=matchsticks[index];

        }
        return false;
    }
}
