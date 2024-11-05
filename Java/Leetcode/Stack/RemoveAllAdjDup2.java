package com.brianprojects.Leetcode.Stack;

import java.util.Stack;

public class RemoveAllAdjDup2 {
    //Time Complexity: O(n) || Space Complexity: O(n)
    private class Node{
        char ch;
        int count;
        public Node(char ch, int count){
            this.ch = ch;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k){
        if(s.length()<k){return s;}
        StringBuilder res = new StringBuilder();
        Stack<Node> stack = new Stack<>();

        for(int i = s.length()-1; i>=0; i--){
            if(stack.isEmpty() || stack.peek().ch != s.charAt(i)){
                stack.push(new Node(s.charAt(i), 1));
            }
            else if(!stack.isEmpty() && stack.peek().ch == s.charAt(i) && stack.peek().count != k-1){
                stack.peek().setCount(stack.peek().getCount()+1);
            }
            else if(!stack.isEmpty() && stack.peek().ch == s.charAt(i) && stack.peek().count == k-1){
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            Node ch = stack.pop();
            int count =ch.getCount();
            while(count>0){
                res.append(ch.ch);
                count--;
            }
        }
        return res.toString();
    }
}
