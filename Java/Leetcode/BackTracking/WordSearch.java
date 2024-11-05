package com.brianprojects.Leetcode.BackTracking;

//Time Complexity is: O(m*n)*(4^t) with t being the length of the string (target) | Space Complexity is: O(m*n)
public class WordSearch {
    public boolean exist(char[][] board, String word){
        int r = board.length;
        int c = board[0].length;

        for(int row = 0; row<board.length; row++){
            for(int col = 0; col<board[row].length; col++){
                if(word.charAt(0) == board[row][col] && wordExits(board, new int[r][c],word ,row, col, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordExits(char[][] board, int[][] emptyBoard, String word,int row, int col, int index) {
        if(index >= word.length()){
            return true;
        }
        if(row <0 || row>board.length-1 || col<0 || col>board[row].length-1){
            return false;
        }
        if(board[row][col] != word.charAt(index) || emptyBoard[row][col] == 1){
            return false;
        }
        emptyBoard[row][col]++;
        if(!(wordExits(board, emptyBoard,word ,row-1, col, index+1)
                || wordExits(board, emptyBoard,word ,row+1, col, index+1)
                || wordExits(board, emptyBoard,word ,row, col-1, index+1)
                ||wordExits(board, emptyBoard,word ,row, col+1, index+1))){

            emptyBoard[row][col]--;
            return false;
        }
        return true;
    }

}



//////////////////////////////////////////////////////////////////////////////////////////////////
/*

private boolean wordExits(char[][] board, int[][] emptyBoard, String word,int row, int col, int index) {
        if(index >= word.length()){
            return true;
        }
        if(row <0 || row>board.length-1 || col<0 || col>board[row].length-1){
            return false;
        }
        for(int r = row; r<board.length; r++){
            for(int c = col; c<board[row].length; c++){
                if(word.charAt(index) == board[r][c]){
                    emptyBoard[row][col]++;
                    wordExits(board, emptyBoard,word, r-1, c, index+1);
                    wordExits(board, emptyBoard,word ,r+1, c, index+1);
                    wordExits(board, emptyBoard,word ,r, c-1, index+1);
                    wordExits(board, emptyBoard,word ,r, c+1, index+1);
                    emptyBoard[r][c]--;
                }
            }
        }
        return false;
    }
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
if(index >= word.length()){
            return true;
        }
        if(row <0 || row>board.length-1 || col<0 || col>board[row].length-1){
            return false;
        }
        if(board[row][col] != word.charAt(index) || emptyBoard[row][col] == 1){
            return false;
        }
        emptyBoard[row][col]++;
        return wordExits(board, emptyBoard,word ,row-1, col, index+1)|| wordExits(board, emptyBoard,word ,row+1, col, index+1)||
                wordExits(board, emptyBoard,word ,row, col-1, index+1)||wordExits(board, emptyBoard,word ,row, col+1, index+1);

 */