package com.brianprojects.Leetcode.LinkedList;



public class ReverseLL2 {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || right<=left ){
            return head;
        }

        var start = 1;
        ListNode prev = head;
        while(start+1 < left){
            prev = prev.next;
            start++;
        }

        ListNode nodeStart = left == 1?prev:prev.next;
        ListNode nodeEnd = nodeStart;
        var end = 0;

        while (end < right-left && nodeEnd != null){
            nodeEnd = nodeEnd.next;
            end++;
        }

        ListNode next = nodeEnd.next;
        nodeEnd.next = null;


        var current = nodeStart;//2
        var currentNext = nodeStart.next;//3

        while(currentNext != null){
            ListNode temp = currentNext.next; //4
            currentNext.next = current; //1
            current = currentNext;
            currentNext = temp;
        }

        nodeStart.next = next;

        if(left == 1){
            return current;
        }
        prev.next  = current;
        return head;
    }
}
