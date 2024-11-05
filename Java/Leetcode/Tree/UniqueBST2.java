package com.brianprojects.Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST2 {
    public List<TreeNode> generateTree(int n){
        if(n <1 || n>8){return new ArrayList<>();}

        return generate(1,n);

    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start>end){res.add(null);return res;}

        for(int i = start; i<=end; i++){
            List<TreeNode> left = generate(start, i-1);
            List<TreeNode> right = generate(i+1, end);

            for(TreeNode l :left){
                for(TreeNode r:right){
                   TreeNode root = new TreeNode(i);
                   root.left = l;
                   root.right = r;
                   res.add(root);
                }
            }

        }
        return res;
    }
}
