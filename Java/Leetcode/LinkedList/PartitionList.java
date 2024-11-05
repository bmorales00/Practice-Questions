package com.brianprojects.Leetcode.LinkedList;

public class PartitionList {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public ListNode partition(ListNode head, int x){
        if(head == null){return null;}
        ListNode lessThan = null;
        ListNode greaterThan = null;

        ListNode current = head;

        ListNode greaterThanHead = null;
        ListNode lessThanHead = null;

        while(current != null){
            if(current.val < x){
                if(lessThan ==null){
                    lessThan = new ListNode(current.val);
                    lessThanHead = lessThan;
                }
                else{
                    lessThan.next = new ListNode(current.val);
                    lessThan = lessThan.next;
                }
            }
            else{
                if(greaterThan == null){
                    greaterThan = new ListNode(current.val);
                    greaterThanHead = greaterThan;
                }
                else{
                    greaterThan.next = new ListNode(current.val);
                    greaterThan = greaterThan.next;
                }
            }
            current = current.next;
        }
        if(lessThanHead == null){return greaterThanHead;}
        else if(greaterThanHead == null){return lessThanHead;}
        else{lessThan.next = greaterThanHead; return lessThanHead;}
    }
}
