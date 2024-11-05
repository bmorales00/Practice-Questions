package com.brianprojects.Leetcode.Array;

public class ZeroFilledSub {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public long zeroFilledSubarray(int[] nums){
        if(nums == null){return 0;}
        long res = 0;

        int l =0;
        while(l<nums.length){
            if(nums[l] !=0){l++;continue;}
            int r = l;
            while(r+1<nums.length && nums[r+1] == 0){
                r++;
            }
            res+=sumOfZeroes((r-l)+1);
            l=r+1;
        }
        return res;
    }

    private long sumOfZeroes(int i) {
        long sum = 0;
        long total =1;
        while(i>0){
            sum+=total++;
            i--;
        }
        return sum;
    }
}
