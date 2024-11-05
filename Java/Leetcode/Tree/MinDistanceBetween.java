package com.brianprojects.Leetcode.Tree;

import java.util.ArrayList;

public class MinDistanceBetween {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int minDiffInBST(TreeNode root){
        if(root == null){return -1;}
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<list.size(); i++){
            min = Math.min(min, list.get(i)-list.get(i-1));
        }
        return min;
    }
    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if(root == null){return;}
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right,list);
    }
}
