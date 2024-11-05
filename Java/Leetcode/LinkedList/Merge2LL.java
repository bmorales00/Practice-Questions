package com.brianprojects.Leetcode.LinkedList;

public class Merge2LL {
    /*
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists in a one sorted list. The list should be made
    by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.
     */

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        ListNode head = mergedList;

        while (list1 != null || list2 != null) {
            if(list1 == null){
                mergedList.next = list2;
                break;
            }
            if(list2 == null){
                mergedList.next = list1;
                break;
            }
            if (list1.val <= list2.val) {
                mergedList.next = list1;
                mergedList = mergedList.next;
                list1 = list1.next;
            }
            else{
                mergedList.next = list2;
                mergedList = mergedList.next;
                list2 = list2.next;
            }
        }
        return head.next;
    }
}
