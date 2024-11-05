package com.brianprojects.Leetcode.LinkedList;

public class LLCycle {
    /*
    Given head, the head of a linked list, determine if the linked list has a cycle in it.
    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
    following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
    Note that pos is not passed as a parameter.
    Return true if there is a cycle in the linked list. Otherwise, return false.
     */

    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }

        var slowPointer = head;
        var fastPointer = head;

        while(fastPointer != null && fastPointer.next !=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }
}
