package com.brianprojects.Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n){
        if(n <=0 || n>9){
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        //int[][] board = new int[n][n];
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> posDiagonal = new HashSet<>(); //Row+Col
        HashSet<Integer> negDiagonal = new HashSet<>(); //Row-Col

        backTracking(res, new ArrayList<>(),n,0,col, posDiagonal, negDiagonal);

        return res;

    }

    private void backTracking(List<List<String>> res,List<String> list ,int boardLength,int index,HashSet<Integer> col,
                              HashSet<Integer> posDiagonal, HashSet<Integer> negDiagonal) {

        //Base Case
        if(index>=boardLength){
            res.add(new ArrayList<>(list));
            return;
        }

        StringBuilder sol = new StringBuilder(".".repeat(boardLength)); //"...."
        for(var c = 0; c<boardLength; c++){ // 0
            if(!col.contains(c) && !posDiagonal.contains(index+c) && !negDiagonal.contains(index-c)){
                //ADD
                col.add(c);
                posDiagonal.add(index+c);
                negDiagonal.add(index-c);
                sol.replace(c,c+1, "Q");
                list.add(sol.toString());

                //Recursive Case
                backTracking(res, list,boardLength, index+1, col, posDiagonal,negDiagonal);

                //REMOVE
                sol.replace(c,c+1, ".");
                list.remove(list.size()-1);
                col.remove(c);
                posDiagonal.remove(index+c);
                negDiagonal.remove(index-c);
            }
        }
    }
}
