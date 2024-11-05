package com.brianprojects.Leetcode.Tree;

import java.util.*;

public class OperationsOnTree {
    private final int[] parent;
    private final int[] locker;
    private final HashMap<Integer, List<Integer>> map;

    public OperationsOnTree(int[] parent) {
        this.parent = parent;
        this.locker = new int[parent.length];
        this.map = new HashMap<>();
        Arrays.fill(locker, -1);
        fillMap();
    }

    public boolean lock(int num, int user){
        if(num >= locker.length || num<0 || locker[num] != -1){return false;}
        locker[num] = user;
        return true;
    }
    public boolean unlock(int num, int user){
        if(num >= locker.length || num<0 || locker[num] != user){return false;}
        locker[num] = -1;
        return true;
    }

    public boolean upgrade(int num, int user){
        if(locker[num] != -1){return false;}
        if(!unlockedAnces(num)){return false;}

        return lockedDesc(num, user);
    }

    private boolean lockedDesc(int num , int user) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(num);
        boolean isLocked = false;
        while(!queue.isEmpty()){
            int val = queue.poll();
            if(this.map.containsKey(val) && !this.map.get(val).isEmpty()){
                var desc = map.get(val);
                for (Integer integer : desc) {
                    if (this.locker[integer] != -1) {
                        isLocked = true;
                        this.locker[integer] = -1;
                        locker[num] = user;
                    }
                    queue.offer(integer);
                }
            }
        }
        return isLocked;
    }

    private boolean unlockedAnces(int num) {
        int start = num;
        while(start != -1){
            if(this.locker[start] != -1){return false;}
            start = parent[start];
        }
        return true;
    }
    private void fillMap(){
        for(int i = 1; i <this.parent.length;i++){
            if(!this.map.containsKey(parent[i])){
                this.map.put(parent[i], new ArrayList<>());
            }
            this.map.get(parent[i]).add(i);
        }
    }
}
