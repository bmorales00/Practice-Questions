package com.brianprojects.Leetcode.DP1D;

public class UncrossedLines {
    //Time Complexity: O(r*c) or O(n) || Space Complexity: O(r*c) or O(n)
    //Tabulation Approach : Bottom Up
    public int maxUncrossedLines(int[] nums1, int[] nums2){

        if(nums1 == null || nums2 == null){return -1;}
        int r = nums1.length+1;
        int c = nums2.length+1;
        int[][] matrix = new int[r][c];

        for(int i = 1; i<r; i++){
            for(int j = 1; j<c; j++){
                if(nums1[i-1] == nums2[j-1]){
                    matrix[i][j] = matrix[i-1][j-1]+1;
                }
                else{
                    matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
                }
            }
        }
        return matrix[r-1][c-1];
    }
}
