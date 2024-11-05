package com.brianprojects.Leetcode.MathAndGeo;

import java.util.ArrayDeque;
import java.util.Queue;

public class SetMatrixZeroes {
    //Time Complexity: O(RC) || Space Complexity:O(1)
    public void setZeroes(int[][] matrix){
        if(matrix == null){return;}
        Queue<int[]> queue = new ArrayDeque<>();
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i =0; i<r;i++){
            for(int j = 0; j<c; j++){
                if(matrix[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            fillCzeroes(matrix,arr[0]);
            fillRzeroes(matrix,arr[1]);
        }
    }

    private void fillCzeroes(int[][] matrix, int index) {
        int c = matrix[index].length;
        for(int i =0; i<c;i++){
            matrix[index][i] = 0;
        }
    }

    private void fillRzeroes(int[][] matrix,int index) {

        int r = matrix.length;
        for(int i = 0; i<r;i++){
            matrix[i][index] = 0;
        }

    }


}
