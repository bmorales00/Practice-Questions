package com.brianprojects.Leetcode.BinarySearch;

public class SplitArray {

    //Time Complexity: O(log s)*O(n)
    //Space Complexity: O(1)
    public int splitArray(int[] nums, int k){
        if(nums == null || k == 0 || k>nums.length){return -1;}
        int total = 0;
        int max = Integer.MIN_VALUE;
        for(int val:nums){
            total+=val;
            max = Math.max(max, val);
        }
        int low = max;
        int high = total;
        int res = total;

        if(k==1){return total;}
        if(k==nums.length){return max;}

        while(low<=high){
            int mid = (high+low)/2;
            if(isSplittable(nums, mid, k)){
                res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }

    private boolean isSplittable(int[] nums, int mid, int k) {
        int total = 0;
        int numOfSub = 1;
        for (int num : nums) {
            total += num;
            if (total > mid) {
                total = num;
                numOfSub++;
            }
        }
        return numOfSub <= k;
    }
}
