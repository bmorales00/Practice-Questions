package com.brianprojects.Leetcode.TwoPointers;

public class MergeSortedArrays {
    // Time Complexity: O(m+n) || Space Complexity: O(n)
    public void merge(int[] nums1, int m ,int[] nums2, int n){
        if(nums1 == null || nums2 == null || nums1.length<m || nums2.length<n || nums2.length == 0){
            return;
        }

        int[] temp = new int[m];
        int start = 0;
        while(start< temp.length){
            temp[start] = nums1[start];
            start++;
        }

        start = 0;
        int start1 = 0;
        int i =0;

        while(start < m && start1 < n){
            if(temp[start] > nums2[start1]){
                nums1[i++] = nums2[start1++];
            }
            else{
                nums1[i++] = temp[start++];
            }
        }

        while(start< m){
            nums1[i++] = temp[start++];
        }
        while(start1 < n){
            nums1[i++] = nums2[start1++];
        }

    }
}
