package com.brianprojects.Leetcode.Tree;

public class SortedToBST {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums == null){
            return new TreeNode();
        }
        if(nums.length==1){return new TreeNode(nums[0]);}


        return dfs(nums, 0, nums.length);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if(start > end || start >= nums.length){
            return null;
        }

        int mid = (end+start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start,mid-1);
        root.right = dfs(nums, mid+1,end);
        return root;
    }
}
