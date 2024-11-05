package com.brianprojects.Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public List<Integer> preorderTravversal(TreeNode root) {
        if(root == null){return new ArrayList<>();}
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if(root == null){return;}
        res.add(root.val);
        dfs(root.left,res);
        dfs(root.right,res);
    }
}
