package com.brianprojects.Leetcode.Array;

public class MyHashMap {
    private final int[][] mapper;
    public MyHashMap(){
        this.mapper = new int[1000001][];
    }
    public void put(int key, int value){
        if(this.mapper[key] == null || this.mapper[key].length == 0){
            mapper[key] = new int[]{key, value};
            return;
        }
        this.mapper[key][1] = value;
    }
    public int get(int key){
        if(this.mapper[key] == null || this.mapper[key].length == 0) {
            return -1;
        }
        return this.mapper[key][1];
    }
    public void remove(int key){
        if(this.mapper[key] == null || this.mapper[key].length == 0){return;}
        this.mapper[key] = null;
    }

}
