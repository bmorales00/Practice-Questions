package com.brianprojects.Leetcode.Array;

public class Unique3LenPalSub {
    //Time Complexity: O(n*m) || Space Complexity: O(1)
    public int countPalindromeSubsequence(String s){
        if(s == null || s.length()<3){return 0;}
        boolean[] visited = new boolean[26];
        int count = 0;

        for(int i = 0; i<=s.length()-3; i++){
            if(!visited[s.charAt(i)-97]){
                visited[s.charAt(i)-97] = true;
                int j = s.length()-1;
                while(j>=i+2 && s.charAt(j) != s.charAt(i)){j--;}
                boolean[] unqiue = new boolean[26];
                int index = j-i-1;
                while(index >0){
                    if(!unqiue[s.charAt(j-index)-97]){
                        unqiue[s.charAt(j-index)-97] = true;
                        count++;
                    }
                    index--;
                }
            }
        }
        return count;
    }
}
