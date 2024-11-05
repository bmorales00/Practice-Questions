package com.brianprojects.Leetcode.LinkedList;

public class MyLinkedList1 {
    private MyLinkedList1 head;
    private MyLinkedList1 tail;
    private int indx;
    private int val;
    private MyLinkedList1 next;
    private MyLinkedList1 prev;
    public MyLinkedList1() {
        head = null;
        next = null;
        prev = null;
        tail = null;
        indx = 0;
    }
    public int get(int index) {
        if(head == null && index ==0){
            throw new IllegalStateException();
        }
        if(index>indx){
            throw new IllegalArgumentException();
        }
        var current = head;
        int i = 0;
        while(current != null && index <= indx && i!=index){
            i++;
            current = current.next;
        }

        return current.val;
    }

    public void addAtHead(int val) {
        if(head == null){
            head = new MyLinkedList1();
            head.val = val;
            tail  = head;
            return;
        }
        var newHead= new MyLinkedList1();
        newHead.val = val;
        newHead.next = head;
        head.prev = newHead;
        head = newHead;
        indx++;
    }

    public void addAtTail(int val) {
        if(head == null){
            head = new MyLinkedList1();
            head.val = val;
            tail  = head;
            return;
        }
        indx++;
        tail.next = new MyLinkedList1();
        tail.next.val = val;
        tail.next.prev = tail;
        tail = tail.next;

    }

    public void addAtIndex(int index, int val) {
        if(index>indx){
            var node = new MyLinkedList1();
            node.val = val;
            tail.next = node;
            node.prev = tail;
            tail = node;
            indx++;
            return;
        }
        if(index == 0){
            if(indx == 0 && head == null){
                head = new MyLinkedList1();
                head.val = val;
                return;
            }
            var node = new MyLinkedList1();
            node.val = val;
            node.next = head;
            head.prev = node;
            head = node;
            indx++;
            return;
        }
        var current = head;
        int i = 0;
        while(current != null && i!=index){
            i++;
            current = current.next;
        }
        var node = new MyLinkedList1();
        node.val = val;
        node.prev = current.prev;
        current.prev.next = node;
        node.next = current;
        current.prev = node;
        indx++;
    }

    public void deleteAtIndex(int index) {
        if(index == 0){
            if(indx ==0){
                head= new MyLinkedList1();
                tail = head;
                return;
            }
            head = head.next;
            head.prev = null;
            indx--;
            return;
        }
        if(index == indx){
            var temp = tail.prev;
            temp.next = null;
            tail = temp;
            indx--;
            return;
        }
        var current = head;
        int i = 0;
        while(current != null && i!=index){
            i++;
            current = current.next;
        }
        var l = current.prev;
        var r = current.next;
        l.next = r;
        r.prev = l;
        indx--;
    }
}
