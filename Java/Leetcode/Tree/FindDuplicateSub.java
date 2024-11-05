package com.brianprojects.Leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSub {
    //Time ComplexityL O(n^2) || Space Complexity: O(n)
    public List<TreeNode> findDuplicateSibtrees(TreeNode root){
        if(root == null){return new ArrayList<>();}
        List<TreeNode> res = new ArrayList<>();
        dfs(root, res, new HashMap<>());
        return res;
    }

    private String dfs(TreeNode root, List<TreeNode> res, HashMap<String, Integer> map) {
        if(root == null){return "n";}
        String serial = root.val+","+dfs(root.left,res, map)+","+dfs(root.right,res,map);
        map.put(serial, map.getOrDefault(serial,0) +1);
        if(map.get(serial) == 2){res.add(root);}
        return serial;
    }


}
