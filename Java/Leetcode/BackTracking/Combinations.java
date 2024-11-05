package com.brianprojects.Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

//    Time Complexity : O(k*nCk), here nCk means the binomial coefficient of picking k elements out of n elements. where nCk = C(n,k) = n!/(n−k)!×k!.
//    Space complexity: O(nCk), as stated above the nCk here refers to the binomial coefficient.
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res = new ArrayList<>();

        backtrack(n,k,1,res, new ArrayList<>());
        return res;
    }

    private void backtrack(int n, int k, int start, List<List<Integer>> res, List<Integer> com) {
        if(k==0){
            res.add(new ArrayList<>(com));
            return;
        }
        for(int i = start; i<=n-k+1;i++){
            com.add(i);
            backtrack(n,k-1,i+1,res,com);
            com.remove(com.size()-1);
        }

    }
}
