package com.brianprojects.Leetcode.Tree;

public class SumRootLeafNum {
    //Time Complexity: O(n)|| Space Complexity: O(n)
    public int sumNumbers(TreeNode root){
        if(root == null){
            return 0;
        }
        StringBuilder nums = new StringBuilder();

        return dfs(root, nums);
    }
    private int dfs(TreeNode root, StringBuilder nums) {
        if(root == null){
            return 0;
        }
        int total = 0;
        nums.append(root.val);
        if(isLeafNode(root)){
            int t = Integer.parseInt(nums.toString());
            nums.deleteCharAt(nums.length()-1);
            return t;
        }
        total+= dfs(root.left, nums);
        total+=dfs(root.right,nums);
        nums.deleteCharAt(nums.length()-1);
        return total;
    }
    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }

    //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    /*
    public int sumNumbers(TreeNode root){
            List<Integer> numbers = new ArrayList<>();
            StringBuilder nums = new StringBuilder();

            dfs(root, nums, numbers);
            int total = 0;
            for(var n:numbers){
                total+=n;
            }
            return total;
        }

        private void dfs(TreeNode root, StringBuilder nums, List<Integer> numbers) {
            if(root == null){
                return;
            }
            nums.append(root.val);
            if(isLeafNode(root)){
                numbers.add(Integer.parseInt(nums.toString()));
            }
            dfs(root.left, nums,numbers);
            dfs(root.right, nums,numbers);
            nums.deleteCharAt(nums.length()-1);
        }
 */
}
