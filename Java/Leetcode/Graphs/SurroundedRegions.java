package com.brianprojects.Leetcode.Graphs;

public class SurroundedRegions {
    public void solve(char[][] board){

        for(var r = 0; r < board.length; r++){
            for(var c = 0; c < board[r].length; c++){
                if(r == 0 || r == board.length-1 || c == 0 || c == board[r].length-1){
                    dfsToN(board, r ,c);
                }
            }
        }

        for(var r = 1; r < board.length-1; r++){
            for(var c = 1; c < board[r].length-1; c++){
                if(board[r][c] == 'O'){
                    dfs(board, r,c);
                }
            }
        }

        for(var r = 0; r < board.length; r++){
            for(var c = 0; c < board[r].length; c++){
                if(r == 0 || r == board.length-1 || c == 0 || c == board[r].length-1){
                    dfsToO(board, r ,c);
                }
            }
        }

    }


    private void dfs(char[][] board, int r, int c) {
        if(r<=0 || r>= board.length-1){
            return;
        }
        if(c <= 0 || c>=board[r].length-1){
            return;
        }
        if(board[r][c] == 'O'){
            board[r][c] = 'X';
            dfs(board, r-1,c);
            dfs(board,r+1, c);
            dfs(board, r, c-1);
            dfs(board, r, c+1);
        }

    }

    public void dfsToN(char[][] board, int r, int c){
        if(r<0 || r>= board.length){
            return;
        }
        if(c < 0 || c>=board[r].length){
            return;
        }
        if(board[r][c] == 'O'){
            board[r][c] = 'N';
            dfsToN(board, r-1,c);
            dfsToN(board,r+1, c);
            dfsToN(board, r, c-1);
            dfsToN(board, r, c+1);
        }

    }
    private void dfsToO(char[][] board, int r, int c) {
        if(r<0 || r>= board.length){
            return;
        }
        if(c < 0 || c>=board[r].length){
            return;
        }
        if(board[r][c] == 'N'){
            board[r][c] = 'O';
            dfsToO(board, r-1,c);
            dfsToO(board,r+1, c);
            dfsToO(board, r, c-1);
            dfsToO(board, r, c+1);
        }
    }
}
