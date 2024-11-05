package com.brianprojects.LeetQues75.Tree;

import java.util.Stack;

public class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return lowestCommonAncestor(root, p,q,root);
    }
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode lca) {
        if (root == null) {
            return lca;
        }

        if (p.val < root.val && q.val < root.val) {
            lca = lowestCommonAncestor(root.left, p, q, root);
        } else if (p.val > root.val && q.val > root.val) {
            lca = lowestCommonAncestor(root.right, p, q, root);
        } else {

            return root;
        }
        return lca;
    }
}
    /*
    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is
    defined between two nodes p and q as the lowest node in T that has both p and q as descendants
    (where we allow a node to be a descendant of itself).”
     */

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        if (p.val < root.val && q.val < root.val) {
//            lowestCommonAncestor(root.left, p, q, root);
//        }
//        else if (p.val > root.val && q.val > root.val) {
//            lowestCommonAncestor(root.right, p, q, root);
//        }
//        else{
//            return root;
//        }
//        return lca;
//    }
//    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode lca) {
//        if(root == null){
//            return lca;
//        }
//
//        if (p.val < root.val && q.val < root.val) {
//            lca =  lowestCommonAncestor(root.left, p, q, root);
//        }
//        else if (p.val > root.val && q.val > root.val) {
//            lca = lowestCommonAncestor(root.right, p, q, root);
//        }
//        else{
//
//            return root;
//        }
//        return lca;
//    }
//}


/*
if((current.left.val == p.val &&  current.right.val == q.val) || (current.left.val == q.val && current.right.val == p.val )
                    || (current.val == p.val && current.left.val == q.val)|| (current.val == q.val && current.left.val == p.val)
                    || (current.val == p.val && current.right.val == q.val)|| (current.val == q.val && current.right.val == p.val)){
                break;
            }
            stack.push(current.right);
            stack.push(current.left);
 */