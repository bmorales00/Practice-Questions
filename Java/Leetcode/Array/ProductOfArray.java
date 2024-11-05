package com.brianprojects.Leetcode.Array;

public class ProductOfArray {

    /*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of
    all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.
     */

    //[1,2,3,4]

    //^ == i == 1

    public int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];

        for(int i = 0, temp = 1 ; i<nums.length; i++){
            result[i] = temp;
            temp*=nums[i];
        }
        for(int j = nums.length-1 , temp = 1; j>=0; j--){
            result[j]*=temp;
            temp*=nums[j];
        }

        return result;
    }
}