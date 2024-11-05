package com.brianprojects.LeetQues75.Tree;

import com.brianprojects.DataStruc.ArrayQueue;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    /*
    Given the root of a binary tree, return the level order traversal of its nodes' values.
    (i.e., from left to right, level by level).
     */


    public List<List<Integer>> levelOrder(TreeNode root){
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        levelOrder(root,map, 0);
        return new ArrayList<>(map.values());
    }

    private void levelOrder(TreeNode root,HashMap<Integer, List<Integer>> map,int height){
        if(root == null){
            return;
        }
        if(!map.containsKey(height)){
            map.put(height, new ArrayList<>());
            map.get(height).add(root.val);
        }
        else{
            map.get(height).add(root.val);
        }
        levelOrder(root.left,map,height+1);
        levelOrder(root.right,map,height+1);

    }


}
/*
var current = queue.removeFirst();
            if(current.left != null && current.right != null){
                res.add(List.of(current.left.val, current.right.val));
                queue.add(current.left);
                queue.add(current.right);

            }
            if(current.left != null && current.right ==null){
                res.add(List.of(current.left.val));
                queue.add(current.left);
            }

            if(current.left == null && current.right != null){
                res.add(List.of(current.right.val));
                queue.add(current.right);
            }
 */