package com.brianprojects.LeetQues75.LinkedList;

public class ReverseLL {
    /*
    Given the head of a singly linked list, reverse the list, and return the reversed list.
     */

    public static ListNode reverseList(ListNode head) {
        //[1-2-3-4-5]
        if(head == null || head.next == null ){
            return head;
        }
        var current = head; //1
        var next = current.next;//2

        while(next != null){
            ListNode temp = next.next; //3
            next.next = current; //1
            current = next;
            next = temp;
        }

        head.next = null;
        head = current;
        return head;
    }
}
