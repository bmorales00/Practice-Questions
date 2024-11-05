package com.brianprojects.Leetcode.DP1D;

// Time Complexity is: O(n)| Space Complexity: O(n)
public class MaxSubMinProd {
    public int maxSumMinProduct(int[] nums){
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int[] left = new int[n];
        left[0] = -1;
        for (int i = 0; i < n; i++) {
            int curr = i - 1;
            while (curr >= 0 && nums[curr] >= nums[i]) {
                curr = left[curr];
            }
            left[i] = curr;
        }
        int[] right = new int[n];
        right[n - 1] = n;
        for (int i = n - 1; i >= 0; i--) {
            int curr = i + 1;
            while (curr < n && nums[curr] >= nums[i]) {
                curr = right[curr];
            }
            right[i] = curr;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            var x = (preSum[right[i]] - preSum[left[i] + 1]) * nums[i];
            res = Math.max(res, x);
        }
        return (int) (res % (int) (Math.pow(10, 9) + 7));
    }
}

/*
int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) { // prefix Sum
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) { // find the first element' value < nums[i] in the left
            while (!stk1.isEmpty() && nums[i] <= nums[stk1.peek()]) {
                stk1.pop();
            }
            if (stk1.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stk1.peek();
            }
            stk1.push(i);
        }
        for (int i = n - 1; i >= 0; i--) { //  find the first element' value < nums[i] in the right
            while (!stk2.isEmpty() && nums[i] <= nums[stk2.peek()]) {
                stk2.pop();
            }
            if (stk2.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stk2.peek();
            }
            stk2.push(i);
        }
        long max = 0;
        for (int i = 0; i < n; i++) { // make current element as Min value
            int l = left[i];
            int r = right[i];
            long sum = prefixSum[r] - prefixSum[l + 1];
            long prod = sum * nums[i];
            max = Math.max(prod, max);
        }
        return (int) (max % 1_000_000_007);
 */