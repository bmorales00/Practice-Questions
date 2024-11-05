package com.brianprojects.Leetcode.BitManipulation;

public class ReverseInteger {
    //Time Complexity: O(n) || Space Complexity:O(n)
    public int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {return 0;}
        boolean wasNeg = false;
        if (x < 0) {
            wasNeg = true;
            x *= -1;
        }
        StringBuilder rev = new StringBuilder();
        String str = Integer.toString(x);
        for (int i = str.length() - 1; i >= 0; i--) {
            if (rev.length() == 0 && str.charAt(i) == '0' && str.length() >1) {
                continue;
            }
            rev.append(str.charAt(i));
        }
        long sub = Long.parseLong(rev.toString());
        if(sub >=Integer.MAX_VALUE){
            return 0;
        }
        int res = Integer.parseInt(rev.toString());
        if (wasNeg) {
            res *= -1;
        }
        return res;
    }
}
