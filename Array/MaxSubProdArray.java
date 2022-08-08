package com.brianprojects.LeetQues75.Array;

public class MaxSubProdArray {
    /*
    Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
    The test cases are generated so that the answer will fit in a 32-bit integer.
    A subarray is a contiguous subsequence of the array.

     */
    public int maxProduct(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int maxProduct = nums[0];
        for(var i = 1; i<nums.length; i++){
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min *nums[i]), nums[i]);
            if(max > maxProduct){
                maxProduct = max;
            }
        }
        return maxProduct;
    }
}
/*
//[1,-2,-3,4]
 public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max; //-2
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]); // //6
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]); // -3
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

 */



//        var max = nums[0]; //-1
//        var min = nums[0]; //-1
//        var maxProduct = nums[0];
//
//        //[-1,-2,-3]
//
//        for(var i = 1; i<nums.length; i++){
//            if(nums[i] < 0 && nums[i] * min > 0){
//                max = Math.max(max, nums[i] *min);  // max = 2
//            }
//            else if(nums[i] > 0 && nums[i] * min < 0){
//                min = Math.min(min, nums[i] * min);
//            }
//            else if(nums[i] < 0 && maxProduct * nums[i] < 0){
//                min = Math.min(min, nums[i]*maxProduct);
//            }
//
//            max = Math.max(max, nums[i]); // 2 , -2 // 6
//            min = Math.min(min, nums[i] * maxProduct); //-2 // -3
//            maxProduct = max;
//        }
//
//        return maxProduct;
