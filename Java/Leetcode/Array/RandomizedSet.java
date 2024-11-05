package com.brianprojects.Leetcode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    //Time Complexity: O(1) || Space Complexity: O(n)
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;
    public RandomizedSet(){
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    public boolean insert(int val){
        if(this.map.containsKey(val)){return false;}
        this.list.add(val);
        this.map.put(val, list.size()-1);
        return true;
    }
    public boolean remove(int val){
        if(!this.map.containsKey(val) || this.list.isEmpty()){return false;}
        if(list.size() == 1){list.remove(0); map.remove(val);return true;}
        if(list.get(list.size()-1) == val){map.remove(val); list.remove(list.size()-1); return true;}
        int index = this.map.get(val);
        this.map.replace(list.get(list.size()-1), this.map.get(list.get(list.size()-1)), index);
        list.set(index, list.get(list.size()-1));
        this.map.remove(val);
        this.list.remove(this.list.size()-1);
        return true;
    }

    public int getRandom(){
        Random random = new Random();
        int randomIndex = random.nextInt(this.list.size());
        return list.get(randomIndex);
    }

}
