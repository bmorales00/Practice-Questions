package com.brianprojects.Leetcode.DP2D;

public class InterleavingString {
    //Time Complexity: O(m*n) | Space Complexity : O(m*n)
    public boolean isInterleave(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] visited = new boolean[s1.length()+1][s2.length()+1];
        return dfs(s1,s2,s3,0,0,visited);
    }

    private boolean dfs(String s1, String s2, String s3,int i1, int i2, boolean[][] visited) {
        if(i1 == s1.length() && i2 == s2.length()) return true;
        if(i1 > s1.length() || i2 > s2.length()) return false;
        if(visited[i1][i2]) return false;
        visited[i1][i2] = true;
        boolean a = false, b = false;
        if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1+i2)){
            a = dfs(s1, s2, s3, i1+1, i2,visited);
        }
        if(i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1+i2)){
            b = dfs(s1, s2, s3, i1, i2+1, visited);
        }
        return a || b;
    }


}

