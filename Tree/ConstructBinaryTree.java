package com.brianprojects.LeetQues75.Tree;

import com.brianprojects.DataStruc.Tree;

public class ConstructBinaryTree {

    /// Construct Binary Tree from Preorder and Inorder Traversal

    /*
    Given two integer arrays preorder and inorder where preorder is the preorder traversal of
    a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder){
        //TreeNode t = buildTree(preorder, inorder, new TreeNode(),0, 0, inorder.length-1);
        return buildTree(preorder, inorder, new TreeNode(),0, 0, inorder.length-1);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder, TreeNode root,int preorderStart, int inorderStart, int inorderEnd){
        if(preorderStart > preorder.length){
            return null;
        }
        if(inorderEnd < inorderStart){
            return root;
        }
        root = new TreeNode(preorder[preorderStart]);
        var mid = 0;
        for(var i = inorderStart; i<=inorderEnd; i++){
            if(preorder[preorderStart] == inorder[i]){
                mid = i;
                break;
            }
        }
        var leftOver = mid - inorderStart;

        root.left = mid <= inorderStart?null:buildTree(preorder, inorder, root.left, preorderStart+1,inorderStart, mid-1);
        root.right = mid>= inorderEnd?null:buildTree(preorder, inorder, root.right, preorderStart+1+leftOver,mid+1, inorderEnd);
        return root;
    }
}
