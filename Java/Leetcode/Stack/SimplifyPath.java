package com.brianprojects.Leetcode.Stack;

import java.util.Stack;

public class SimplifyPath {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public String simplifyPath(String path) {
        if(path.length() ==0 || path.charAt(0) != '/'){
            return "";
        }
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        String[] pathList = path.split("/");
        StringBuilder simplePath = new StringBuilder();
        for(var i = 0; i<pathList.length; i++){
            if(pathList[i].equals("..") && !stack.isEmpty()){
                stack.pop();
            }
            if(!pathList[i].equals(".") && pathList[i].length() != 0 && !pathList[i].equals("..")){
                stack.push(pathList[i]);
            }
        }
        while(!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        while(!stack2.isEmpty()){
            simplePath.append("/"+stack2.pop());
        }

        return  simplePath.toString().length() == 0? "/":simplePath.toString();
    }
}
