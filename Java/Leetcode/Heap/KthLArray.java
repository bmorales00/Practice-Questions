package com.brianprojects.Leetcode.Heap;

public class KthLArray {
    //Time Complexity: O(n log n) || Space Complexity: O(1)
    public int findKthLargest(int[] nums, int k){
        return kthLargest(nums, k,0,nums.length-1);
    }

    private int kthLargest(int[] nums, int k, int s, int e) {
        if(s>e){return 0;}
        int partition = partition(nums, s,e);
        if(partition == k-1){
            return nums[partition];
        }
        else if(partition<k-1){
            return kthLargest(nums, k, partition+1,e);
        }
        else{
            return kthLargest(nums,k,s,partition-1);
        }
    }

    private int partition(int[] nums, int s, int e) {
        int boundary = s-1;
        for(int i = s; i<nums.length;i++){
            if(nums[i] >= nums[e]){
                var temp = nums[i];
                nums[i] = nums[++boundary];
                nums[boundary] = temp;
            }
        }
        return boundary;
    }
}
