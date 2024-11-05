package com.brianprojects.Leetcode.LinkedList;

public class InsertionSort {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public ListNode insertionSortList(ListNode head){
        if(head== null || head.next == null){return head;}

        ListNode res = new ListNode(head.val);
        ListNode newHead = res;

        ListNode currentOld = head.next;

        ListNode prev = res;
        ListNode curr = res;

        while(currentOld != null){
            while(currentOld.val >= curr.val && curr.next != null){
                prev = curr;
                curr = curr.next;
            }
            ListNode node = new ListNode(currentOld.val);
            if(curr == newHead){
                if(curr.val < node.val){
                    curr.next = node;
                }
                else{
                    node.next = newHead;
                    newHead = node;
                }
            }
            else if(currentOld.val <= curr.val){
                node.next = curr;
                prev.next = node;
            }
            else{
                curr.next= node;
            }
            prev = newHead;
            curr = newHead;
            currentOld = currentOld.next;
        }

        return newHead;
    }
}

/*
if(currentOld.next.val < curr.val){
                ListNode node = new ListNode(currentOld.val);
                if(curr == newHead){
                    node.next = newHead;
                    newHead = node;
                    curr = node;
                    prev  = node;
                }
                else{

                }
            }
 */