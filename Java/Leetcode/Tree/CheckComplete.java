package com.brianprojects.Leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CheckComplete {
    //Time Complexity: O(n) || Space Complexity:O(1)
    public boolean isComplete(TreeNode root){
        if(root == null){return true;}
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left == null && node.right != null){
                return false;
            }
            if(node.val == 0){
                break;
            }
            queue.offer(node.left == null? new TreeNode(0):node.left);
            queue.offer(node.right== null? new TreeNode(0):node.right);
        }
        while(!queue.isEmpty()){
            if(queue.poll().val != 0){
                return false;
            }
        }
        return true;
    }
}
