package com.brianprojects.Leetcode.LinkedList;

public class RemoveDuplicates {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public ListNode deleteDuplicates(ListNode head){
        if(head == null){return null;}

        ListNode current = head;
        ListNode next = head;

        while(next != null ){
            if(next.val == current.val){
                next = next.next;
                continue;
            }
            current.next = next;
            current = current.next;
        }
        if(current.next != next){
            current.next = next;
        }
        return head;
    }
}
