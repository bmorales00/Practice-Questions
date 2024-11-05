package com.brianprojects.Leetcode.LinkedList;

public class ReverseLL {
    /*
    Given the head of a singly linked list, reverse the list, and return the reversed list.
     */

    public ListNode reverseList(ListNode head) {
        //[1-2-3-4-5]
        // 1- 2-1
        //3-4-5
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
    public ListNode reverseListRec(ListNode head) {
        if(head == null){
            return null;
        }
        var listNode = head;
        dfs(listNode, listNode.next, head);

        var temp = head.next;
        head.next = null;
        head = temp;
        return head;
    }

    private void dfs(ListNode current, ListNode next, ListNode head) {
        if(next == null){
            head.next = current;
            return;
        }
        var temp = next.next; //3
        next.next = current;

        dfs(next, temp, head);

    }
}
