package com.brianprojects.Leetcode.Tree;

import java.util.Stack;

public class ConstructInandPost {

    //Time Complexity: O(n^2) || Space Complexity: O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder == null || postorder == null){return null;}
        Stack<Integer> stack = new Stack<>();
        for(int val:postorder){stack.push(val);}
        return buildTree(inorder,0,inorder.length-1, stack);
    }
    private TreeNode buildTree(int[] inorder,int start, int end, Stack<Integer> stack){
        if(stack.isEmpty() || start>end || end>inorder.length){return null;}
        TreeNode root = new TreeNode(stack.pop());
        int index = start;
        for(int i = start; i<=end; i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        root.right = buildTree(inorder,index+1,end,stack);
        root.left = buildTree(inorder,start, index-1, stack);
        return root;
    }
}
