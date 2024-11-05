package com.brianprojects.Leetcode.LinkedList;

public class MyLinkedList {
    private class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val) {
            this.val = val;

        }
    }

    private Node head;
    private Node tail;
    public int indexCount;
    public MyLinkedList() {
    }

    public int get(int index) {
        if(head == null || index>indexCount || index<0){
            return -1;
        }
        var current = head;
        int i = 0;
        while(current != null && i!=index){
            current = current.next;
            i++;
        }

        return current.val;
    }

    public void addAtHead(int val) {
        if(head == null){
            head = new Node(val);
            tail  = head;
            indexCount = 0;
            return;
        }
        var node = new Node(val);
        node.next = head;
        head.prev = node;
        head = node;
        indexCount++;
    }

    public void addAtTail(int val) {
        if(head == null){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        node.prev = tail;
        tail = node;
        indexCount++;
    }

    public void addAtIndex(int index, int val) {
        if(index> indexCount && head == null){return;}
        if(index>indexCount){addAtTail(val);return;}
        if(index == 0){addAtHead(val);return;}
        Node current = head;
        int i = 0;
        while(current != null && i!=index){
            current = current.next;
            i++;
        }
        Node node = new Node(val); //O
        Node prev = current.prev;
        node.prev = prev;
        prev.next = node;
        node.next = current;
        current.prev = node;
        indexCount++;
    }
    public void deleteAtIndex(int index) {
        if(index> indexCount){return;}
        if(index == 0 && head == null){return;}
        if(index == 0 && indexCount==0){this.head = null;this.tail = null; return;}
        if(index ==0){
            Node node = head.next;
            head.next = null;
            node.prev = null;
            head= node;
            indexCount--;
            return;
        }
        if(index == indexCount){
            Node node = tail.prev;
            node.next = null;
            tail.prev = null;
            tail=node;
            indexCount--;
            return;
        }
        Node current = head;
        int i = 0;
        while(current != null && i!=index){
            current = current.next;
            i++;
        }
        Node prev = current.prev;
        Node next = current.next;
        prev.next = next;
        next.prev = prev;
        indexCount--;
    }
}
/*
Using an array list:

        ArrayList<Integer> list;
            public MyLinkedList() {
                list = new ArrayList<>();
            }

            public int get(int index) {
                if(index>=list.size())
                    return -1;
                return list.get(index);
            }

            public void addAtHead(int val) {
                list.add(0, val);
            }

            public void addAtTail(int val) {
                list.add(val);
            }

            public void addAtIndex(int index, int val) {
                if(index>list.size())
                    return;
                list.add(index, val);
            }

            public void deleteAtIndex(int index) {
                if(index >= list.size())
                    return;
                list.remove(index);
            }
 */