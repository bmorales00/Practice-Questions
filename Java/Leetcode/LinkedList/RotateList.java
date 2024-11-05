package com.brianprojects.Leetcode.LinkedList;

public class RotateList {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public ListNode rotateRight(ListNode head, int k){
        if(head ==null || k == 0){return head;}

        ListNode current = head;
        int size = 1;
        while(current.next != null){
            current = current.next;
            size++;
        }
        current.next = head;
        current = head;
        ListNode[] array = new ListNode[size];
        for(var i = 0; i<array.length; i++){
            array[(i+k)%size] = current;
            current = current.next;
        }
        ListNode tail = array[array.length-1];
        tail.next = null;

        return array[0];
    }
}
