package com.brianprojects.Leetcode.Array;

public class SortAnArray {
    public int[] sortArray(int[] nums){

        //mergeSort(nums);
        quickSort(nums);
        return nums;
    }

//    private void mergeSort(int[] nums) {
//        if(nums.length <=1){return;}
//        int mid = nums.length/2;
//        int[] left = new int[mid];
//        for(int i = 0; i<mid; i++){
//            left[i] = nums[i];
//        }
//        int[] right = new int[nums.length-mid];
//        for(int i = 0; i<right.length; i++){
//            right[i] = nums[i+mid];
//        }
//
//        mergeSort(left);
//        mergeSort(right);
//
//        mergeSort(nums,left,right);
//    }
//    private void mergeSort(int[] nums,int[] left,int[] right){
//        int l = 0;
//        int r = 0;
//        int current = 0;
//
//        while(l<left.length && r<right.length){
//            if(left[l] < right[r]){nums[current++] = left[l++];}
//            else{nums[current++] = right[r++];}
//        }
//        while(l<left.length){
//            nums[current++] = left[l++];
//        }
//        while(r<right.length){
//            nums[current++] = right[r++];
//        }
//    }
    private void quickSort(int[] nums){
        quickSort(nums, 0, nums.length-1);
    }
    private void quickSort(int[] nums, int start, int end){
        if(start>=end){return;}

        var boundary = partition(nums, start,end);
        quickSort(nums, start, boundary-1);
        quickSort(nums,boundary, end);

    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int boundary = start-1;
        for(int i = start; i<=end; i++){
            if(nums[i] <= pivot){
                swap(nums, boundary+1,i);
                boundary++;
            }
        }
        return boundary;
    }

    private void swap(int[] nums, int x, int y) {
        var temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
