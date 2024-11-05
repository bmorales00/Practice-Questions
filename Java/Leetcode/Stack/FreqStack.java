package com.brianprojects.Leetcode.Stack;

import java.util.ArrayList;
import java.util.HashMap;

public class FreqStack {
    private class Node {
        private int maxUpToPoint;
        private int nodeVal;
        private int nodeValOcc;
        public Node(int nodeVal, int nodeValOcc, int maxUpToPoint) {
            this.nodeVal = nodeVal;
            this.nodeValOcc = nodeValOcc;
            this.maxUpToPoint = maxUpToPoint;
        }

        public int getMaxUpToPoint() {
            return maxUpToPoint;
        }
        public int getNodeVal() {
            return nodeVal;
        }
        public int getNodeValOcc() {
            return nodeValOcc;
        }
    }
    ArrayList<Node> list;
    HashMap<Integer, Integer> valMap;
    int max = 0;
    public FreqStack() {
        this.list = new ArrayList<>();
        this.valMap = new HashMap<>();
    }
    public void push(int val){
        int valocc;
        if(!valMap.containsKey(val) || valMap.get(val) == 0){
            valMap.put(val, 1);
            valocc = 1;
        }
        else{
            valocc = valMap.get(val)+1;
            valMap.replace(val,valMap.get(val),valocc);
        }
        Node node = new Node(val, valocc, max);
        max = Math.max(valocc, max);
        list.add(node);
    }
    public int pop(){
        if(list.isEmpty()){return -1;}
        for(int i = list.size()-1; i>=0; i--){
            Node node = list.get(i);
            if(node.getNodeValOcc() == max){
                valMap.replace(node.getNodeVal(), valMap.get(node.getNodeVal()),valMap.get(node.getNodeVal())-1);
                max = Math.min(node.getMaxUpToPoint(),max);
                list.remove(i);
                return node.getNodeVal();
            }
        }
        return -1;
    }
}
