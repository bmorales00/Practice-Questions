package com.brianprojects.Leetcode.LinkedList;

import java.util.HashMap;

public class LFUCache {
    //Space Complexity: O(c) for the counter hashmap c being the amount of count or get calls
    // || O(n) for the node hashmap n being the amount of nodes or the initial capacity
    private class Node{
        Node next;
        Node prev;
        int key;
        int value;
        int counter;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.counter = 1;
            next = null;
            prev = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }
    }
    private final int maxCapacity;
    HashMap<Integer, Node[]> countMapper = new HashMap<>();

    HashMap<Integer, Node> nodeMapper = new HashMap<>();
    private int LFU;


    public LFUCache(int capacity) {
        this.maxCapacity = capacity;
        this.LFU = 1;
    }
    //Time Complexity: O(1)

    public int get(int key) {
        if(!nodeMapper.containsKey(key)){return -1;}
        updateKey(key);
        return this.nodeMapper.get(key).getValue();
    }
    //Time Complexity: O(1)
    public void put(int key, int value){
        if(!nodeExists(key)){

            if(isFull()){removeLFU();}

            Node lru = new Node(key, value);
            if(!countExists(1)){
                nodeMapper.put(key, lru);
                countMapper.put(1, new Node[]{lru, lru});
                LFU =1;
            }
            else{
                nodeMapper.put(key, lru);
                var ht_arr = countMapper.get(1);
                Node head = ht_arr[0];
                lru.next = head;
                head.prev = lru;
                ht_arr[0] = lru;
            }
        }
        else{
            Node node = nodeMapper.get(key);
            node.setValue(value);
            updateKey(key);
        }
    }
    private void updateKey(int key){
        Node node = nodeMapper.get(key);
        int nodeCount = node.getCounter();
        var ht_arr = countMapper.get(nodeCount);

        if(node.prev == null && node.next == null){
            countMapper.remove(nodeCount);
        }
        else if(node.prev != null && node.next != null){
            Node next = node.next;
            Node prev =node.prev;
            node.prev = null;
            node.next = null;
            next.prev = prev;
            prev.next = next;
        }
        else if(node.prev == null){
            ht_arr[0] = node.next;
            ht_arr[0].prev = null;
            node.next = null;
        }
        else{
            ht_arr[1] = node.prev;
            ht_arr[1].next = null;
            node.prev = null;
        }

        if(LFU == nodeCount && !countExists(LFU)){
            LFU = nodeCount+1;
        }
        node.setCounter(nodeCount+1);
        if(!countExists(nodeCount+1)){
            countMapper.put(nodeCount+1, new Node[]{node, node});
        }
        else{
            var arr = countMapper.get(nodeCount+1);
            node.next = arr[0];
            arr[0].prev = node;
            arr[0] = node;
        }
    }

    private boolean countExists(int counterKey){
        return this.countMapper.containsKey(counterKey);
    }
    private boolean nodeExists(int key){
        return this.nodeMapper.containsKey(key);
    }
    private boolean isFull(){
        return this.nodeMapper.size() == this.maxCapacity;
    }
    private void removeLFU(){
        var ht_arr = countMapper.get(LFU);
        Node node = ht_arr[1];
        nodeMapper.remove(node.key);

        if(node.prev == null){
            countMapper.remove(LFU);
        }
        else{
            ht_arr[1] = node.prev;
            ht_arr[1].next = null;
        }
    }
}
