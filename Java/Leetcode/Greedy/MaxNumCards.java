package com.brianprojects.Leetcode.Greedy;

public class MaxNumCards {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public int maxScore(int[] cardPoints, int k){
        if(k>cardPoints.length){return -1;}
        int sum =0;
        int i = cardPoints.length-1;
        while(i>=cardPoints.length-k){
            sum+=cardPoints[i];
            i--;
        }
        if(cardPoints.length==k){return sum;}
        int max = sum;
        int j = 0;
        i+=1;
        while(j<k){
            sum-=cardPoints[i++];
            sum+=cardPoints[j++];
            max = Math.max(max, sum);
        }
        return max;
    }
}
