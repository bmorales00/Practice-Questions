package com.brianprojects.Leetcode.LinkedList;

public class MergeKSortedLists {
    /*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
     */

    public ListNode mergeKLists(ListNode[] lists){
        ListNode head = new ListNode();
        for(var i= 0; i<lists.length; i++){
            ListNode current = head;
            ListNode element = lists[i];
            while(element != null){
                if(current.next == null){
                    current.next = new ListNode(element.val);
                    element = element.next;
                    current = current.next;
                }
                else if(element.val<=current.next.val){
                    var temp = current.next;
                    var temp2 = element.next;
                    current.next = element;
                    current.next.next = temp;
                    current = current.next;
                    element = temp2;
                }
                else{
                    current = current.next;
                }
            }

        }
         return head.next;
    }
}
