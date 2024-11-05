package com.brianprojects.Leetcode.DP2D;

public class OnesandZeroes {
    //Time Complexity: O(s*(m*n))   || Space Complexity: O(m*n)
    public int findMaxForm(String[] strs, int m, int n){
        if(strs == null){return 0;}

        int[][] arr = new int[m+1][n+1];
        for (String bin : strs) {
            int z = 0;
            int o = 0;
            for (int j = 0; j < bin.length(); j++) {
                if (bin.charAt(j) == '1') {o++;}
                else {z++;}
            }
            dp(arr, m, n, z, o);
        }
        return arr[m][n];
    }
    private void dp(int[][] arr, int m,int n,int zero, int one){
        for(int i = m;i>=zero; i--){
            for(int j = n; j>=one;j--){
                if(i-zero >=0 && j-one>=0){
                    arr[i][j] = Math.max(1+arr[i-zero][j-one],arr[i][j]);
                }
            }
        }
    }
}
