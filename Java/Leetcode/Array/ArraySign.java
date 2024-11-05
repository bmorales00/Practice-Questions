package com.brianprojects.Leetcode.Array;

public class ArraySign {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public int arraySign(int[] nums){
        if(nums == null){return 0;}
        int neg = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                neg++;
            }
        }
        return neg%2==0?1:-1;
    }
}
