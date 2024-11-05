package com.brianprojects.Leetcode.Tries;

import java.util.HashMap;

public class Trie {
    private class Node{
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }
        public boolean hasChild(char child) {
            return children.containsKey(child);
        }
        public void addChild(char child) {
            children.put(child, new Node(child));
        }
        public Node getChild(char child) {
            return children.get(child);
        }
        public boolean hasChildren() {
            return children.isEmpty();
        }

    }
    private final Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for(var ch:word.toCharArray()){
            if(!current.hasChild(ch)){
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        var current = root;
        for(var ch: word.toCharArray()){
            if(!current.hasChild(ch)){
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String word) {
        var current = root;
        for(var ch: word.toCharArray()){
            if(!current.hasChild(ch)){
                return false;
            }
            current = current.getChild(ch);
        }
        return true;
    }
}
