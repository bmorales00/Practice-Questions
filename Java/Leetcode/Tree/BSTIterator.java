package com.brianprojects.Leetcode.Tree;

import java.util.ArrayList;

public class BSTIterator {
    TreeNode root;
    ArrayList<Integer> list;
    int index;
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.index = 0;

    }
    public int next(){
        if(root == null){return 0;}
        if(list == null){
            this.list = new ArrayList<>();
            list.add(-1);
            dfs(list,root);
        }
        return list.get(++index);
    }
    public boolean hasNext(){
        if(root == null){return false;}
        if(list == null){
            this.list = new ArrayList<>();
            list.add(-1);
            dfs(list,root);
        }
        return index+1<list.size();
    }

    private void dfs(ArrayList<Integer> list, TreeNode root) {
        if(root == null){return;}
        dfs(list,root.left);
        list.add(root.val);
        dfs(list,root.right);
    }
}
