package com.brianprojects.Leetcode.LinkedList;

public class MyCircularQueue {
    //Time Complexity: O(1) || Space Complexity: O(k)
    private class Node{
        private Node next;
        private Node prev;
        private int val;

        public Node(int val) {
            this.val=val;
            this.next = null;
            this.prev = null;
        }
    }
    int maxSize;
    int currSize;

    Node head;
    Node tail;
    public MyCircularQueue(int k) {
        this.maxSize = k;
        this.currSize = 0;
        this.head= null;
        this.tail = null;
    }
    public boolean enQueue(int value){
        if(this.isFull()){return false;}
        Node node = new Node(value);
        if(currSize == 0){head = node;tail = head; currSize++;return true;}
        node.prev = tail;
        node.next = head;
        Node temp = tail;
        tail = node;
        temp.next = tail;
        head.prev = tail;
        currSize++;
        return true;
    }

    public boolean deQueue(){
        if(this.isEmpty()){return false;}
        if(currSize == 1){head = null; tail =null; currSize--; return true;}
        if(currSize ==2){tail.prev = null;tail.next = null; head = tail; currSize--; return true;}
        Node temp = head.next;
        temp.prev = tail;
        tail.next = temp;
        head = temp;
        currSize--;
        return true;
    }

    public int Front(){
        if(this.isEmpty()){return -1;}
        return head.val;
    }
    public int Rear(){
        if(this.isEmpty()){return -1;}
        return tail.val;
    }

    public boolean isEmpty(){
        return currSize == 0;
    }
    public boolean isFull(){
        return currSize == maxSize;
    }

}
