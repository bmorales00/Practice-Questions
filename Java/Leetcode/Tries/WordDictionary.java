package com.brianprojects.Leetcode.Tries;

import java.util.*;


public class WordDictionary {
    private class Node {
        private char value;
        public HashMap<Character, Node> children = new HashMap<>();
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
            return !children.isEmpty();
        }
        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }
    }
    private final Node root = new Node(' ');

    public void addWord(String word) {
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
        int dotPlacement = 0;
        for(var ch: word.toCharArray()){
            if(!current.hasChild(ch) && ch != '.'){
                return false;
            }
            if(ch == '.'){
//                if(dotPlacement+1 > word.length()-1){
//                    return false;
//                }
                return isPotentialWord(word, dotPlacement,current); // Once we go here, we don't care about
                // the rest of the word, we just want to find if its potentially a word
            }
            current = current.getChild(ch);
            dotPlacement++;
        }
        return current.isEndOfWord;
    }

    private boolean isPotentialWord(String word, int dotPlacement,Node root) {
        if(!root.hasChildren()){
            return false;//.ad , [1], '' -> b,m,d
        }
//        if(dotPlacement >= word.length()){
//            return false;//.ad , [1], '' -> b,m,d
//        }
        if(dotPlacement == word.length()-1 && ((word.charAt(dotPlacement) == '.') || root.getChild(word.charAt(dotPlacement)).isEndOfWord)){
            return true;
        }
        if(dotPlacement >=word.length()-1&& !root.getChild(word.charAt(dotPlacement)).isEndOfWord){
            return false;
        }
        for(var ch: root.getChildren()){
            if(ch.hasChild(word.charAt(dotPlacement+1)) && !(dotPlacement+1 >= word.length())){
                return isPotentialWord(word, dotPlacement+1, ch);
            }
        }
        return word.charAt(dotPlacement + 1) == '.';
    }

}
/*
private final HashMap<Integer, Set<String>> map = new HashMap<>();
    public void addWord(String word) {
        var wordLength = word.length();
        if(!map.containsKey(wordLength)){
            Set<String> list = new HashSet<>();
            list.add(word);
            map.put(wordLength, list);
        }
        map.get(wordLength).add(word);
    }

    public boolean search(String word) {
        var wordLength = word.length();
        var indexList = map.get(wordLength);
        int counter = 0;
        if(!map.containsKey(wordLength)){
            return false;
        }
        if(isWords(word)){
            return indexList.contains(word);
        }

        for(var w : indexList){
            if(isPotentialWord(w, word)){
                return true;
            }
        }
        return false;
    }

    private boolean isWords(String word) {
        for(int i = 0; i < word.length(); i++){
            if(!Character.isLetter(word.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private boolean isPotentialWord(String w, String word) {
        if (w.length() != word.length()) {
            return false;
        }
        for (var i = 0; i < word.length(); i++) {
            if (w.charAt(i) != word.charAt(i) && word.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }

 */