package com.brianprojects.Leetcode.Array;

public class MyHashSet {

    private int[] map;
    public MyHashSet() {
        map = new int[1000001];
    }

    public void add(int key){
        if(map[key] ==1){return;}
        map[key] = 1;
    }
    public void remove(int key){
        if(map[key] == 1){
            map[key] = 0;
        }
    }
    public boolean contains(int key){
        return map[key] == 1;
    }
}
