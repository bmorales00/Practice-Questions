package com.brianprojects.Leetcode.Tree;

import java.util.*;

public class BTZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if(root == null){return null;}
        List<List<Integer>> res = new ArrayList<>();
        if(root.left == null && root.right == null){return List.of(List.of(root.val));}

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Integer[] arr = new Integer[queue.size()];
            bfs(arr, queue,res);
            res.add(Arrays.asList(arr));
        }
        return res;
    }

    private void bfs(Integer[] arr, Queue<TreeNode> queue, List<List<Integer>> res) {
        int size = queue.size();
        if(res.size()%2 == 0){
            int start =0;
            while(size >0 && start < arr.length){
                TreeNode node = queue.poll();
                //if(node == null){return;}
                arr[start++] = node.val;
                if(node.left != null){queue.add(node.left);}
                if(node.right != null){queue.add(node.right);}
                size--;
            }
        }
        else{
            int start = arr.length-1;
            while(size>0 && start >=0){
                TreeNode node = queue.poll();
                //if(node == null){return;}
                arr[start--] = node.val;
                if(node.left != null){queue.add(node.left);}
                if(node.right != null){queue.add(node.right);}
                size--;
            }
        }
    }
}
