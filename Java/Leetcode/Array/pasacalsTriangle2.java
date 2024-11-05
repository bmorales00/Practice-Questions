package com.brianprojects.Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class pasacalsTriangle2 {
    //Time Complexity: O(n^2) || Space Complexity: O(n^2)
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex > 33) {
            return null;
        }
        int[][] arr = new int[rowIndex + 1][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            int start = 0;
            int end = arr[i].length - 1;
            arr[i][start] = 1;
            arr[i][end] = 1;
        }
        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        List<Integer> res = new ArrayList<>();
        for( int val:arr[rowIndex]){
            res.add(val);
        }

        return res;
    }
}
