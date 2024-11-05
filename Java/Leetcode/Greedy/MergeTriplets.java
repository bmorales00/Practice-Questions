package com.brianprojects.Leetcode.Greedy;

import java.util.Arrays;

public class MergeTriplets {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public boolean mergeTriplets(int[][] triplets, int[] target){
        if(target == null || triplets == null){return false;}
        int[] res = new int[3];

        for(int[] triplet: triplets){
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                res[0] = Math.max(res[0],triplet[0]);
                res[1] = Math.max(res[1],triplet[1]);
                res[2] = Math.max(res[2],triplet[2]);
            }
            if(Arrays.equals(res, target)){return true;}
        }
        return false;
    }
}
