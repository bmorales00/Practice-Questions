package com.brianprojects.Leetcode.LinkedList;

public class ReorderList {
    /*
    You are given the head of a singly linked-list. The list can be represented as:
    L0 → L1 → … → Ln - 1 → Ln
    Reorder the list to be on the following form:
    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    You may not modify the values in the list's nodes. Only nodes themselves may be changed.
     */
    public static void reorderList(ListNode head) {
        if(head.next == null){
            return;
        }
        //Reorder the middle to be 1-2-3-4-5-6 ->   1-2-3-6-5-4
        var middle = head;
        var end = head.next;
        while(end != null && end.next != null){
            middle = middle.next;
            end = end.next.next;
        }
        ///////////////////////////////////////////////
        var middleRef = middle;

        end = middle.next;
        var next = end.next;
        while(next != null){
            ListNode temp = next.next;
            next.next = end;
            end = next;
            next = temp;
        }
        middle.next.next = null;
        middle.next = end;

        /////////////////////////////////////////////////

        var pointer1 = head;
        var pointer2 = middle.next;

        while(pointer2 != null){
            var temp1 = pointer1.next;// 2-3-6-
            var temp2 = pointer2.next; //5-4
            pointer1.next = pointer2; //1-5
            pointer1 = pointer1.next; // 5
            pointer1.next = temp1; //5-2
            pointer1 = pointer1.next; //2
            pointer2 = temp2; //4
        }
        if(pointer1.val == middleRef.val){
            middle.next= null;
        }
        else{
            middle.next.next = null;
        }
        //newEnd.next = null;
    }

}
//            pointer1.next = temp1;
//            pointer1 = pointer1.next;
//            pointer1.next = temp2;
