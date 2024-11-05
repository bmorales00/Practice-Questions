package com.brianprojects.Leetcode.Tree;

import java.util.*;

public class MaxWidth {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int widthOfBinaryTree(TreeNode root){
        if(root == null){return 0;}
        if(root.left == null && root.right == null){return 1;}
        List<Integer>nodes = new ArrayList<>();
        int[] res = new int[1];
        dfs(root, 1, 0 ,nodes, res);
        return res[0];
    }

    private void dfs(TreeNode root, int val, int level, List<Integer> nodes, int[] res) {
        if (root == null) return;
        if (level >= nodes.size()) nodes.add(val);
        res[0] = Integer.max(res[0], val + 1 - nodes.get(level));
        dfs(root.left,  val * 2,     level + 1, nodes, res);
        dfs(root.right, val * 2 + 1, level + 1, nodes, res);
    }


}
