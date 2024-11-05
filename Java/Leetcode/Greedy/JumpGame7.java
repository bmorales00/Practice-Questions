package com.brianprojects.Leetcode.Greedy;

public class JumpGame7 {
    //TIme Complexity: O(n) || Space Complexity: O(n)
    public boolean canReach(String s, int minJump, int maxJump){
        if(s.length() == 0){return false;}
        if(s.charAt(s.length()-1) -'0'== 1){return false;}

        int n = s.length(), pre = 0;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            if (i >= minJump && dp[i - minJump])
                pre++;
            if (i > maxJump && dp[i - maxJump - 1])
                pre--;
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }

}

/*
if(s.length() == 0){return false;}
        if(s.charAt(s.length()-1) -'0'== 1){return false;}

        int end = s.length()-1;
        int currentEnd = s.length()-1;
        int l = s.length()-2;
        while(l != 0){
            int ch = s.charAt(l)-'0';
            int current = currentEnd -l;
            int last = end - l;
            if(ch == 0 && ((current >=minJump && current <=maxJump) || (last >=minJump && last<=maxJump))){
                currentEnd = l;
            }

            l--;
        }
        return currentEnd>=minJump && currentEnd<=maxJump;
 */