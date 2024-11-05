package com.brianprojects.LeetQues75.Tree;

import java.util.Stack;

public class KthSmallestElementalBST {
    /*
    Given the root of a binary search tree, and an integer k, return the kth smallest
    value (1-indexed) of all the values of the nodes in the tree.
     */

    public static int kthSmallest(TreeNode root, int k){
        if(root == null){
            return -1;
        }
        int smallestKth = 0;
        Stack<TreeNode> stack = new Stack<>();
        var current = root;

        while(!stack.isEmpty() || smallestKth != k){ // [3, 1    ]
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(++smallestKth == k){
                return current.val;
            }
            current = current.right;
        }
        return -1;
    }
}
