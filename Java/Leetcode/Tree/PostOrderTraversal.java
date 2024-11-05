package com.brianprojects.Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public List<Integer> postorderTraversal(TreeNode root){
        if(root == null){return new ArrayList<>();}
        List<Integer> res= new ArrayList<>();
        dfs(root,res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if(root == null){return;}
        dfs(root.left,res);
        dfs(root.right,res);
        res.add(root.val);
    }
}
