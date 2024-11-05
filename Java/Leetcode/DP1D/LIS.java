package com.brianprojects.Leetcode.DP1D;

import java.util.Arrays;
//Time Complexity: O(n^2) Quadratic | Space Complexity: O(n)
public class LIS {
    public int findNumberLIS(int[] nums){

        if(nums == null){return 0;}
        if(nums.length <=1){return 1;}

        int size = nums.length;
        int[] lengthOfC = new int[size];
        int[] numOfC = new int[size];
        Arrays.fill(lengthOfC, 1);
        Arrays.fill(numOfC, 1);
        int max = 1;
        int res = 0;

        for(var i = 1; i<size; i++){
            int maxIndex=1;
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j]) {
                    if(maxIndex<lengthOfC[j]+1)
                    {
                        maxIndex=lengthOfC[j]+1;
                        numOfC[i]=numOfC[j];
                    }
                    else if(maxIndex==lengthOfC[j]+1){numOfC[i]+=numOfC[j];}
                }

            }
            lengthOfC[i]=maxIndex;

            max=Math.max(lengthOfC[i],max);
        }
        for(var i = 0; i<size; i++){
            if(lengthOfC[i] == max){
                res+= numOfC[i];
            }
        }
        return res;
    }

}
