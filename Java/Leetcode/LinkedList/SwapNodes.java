package com.brianprojects.Leetcode.LinkedList;

public class SwapNodes {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public ListNode swapPairs(ListNode head){
        if(head == null){return head;}
        ListNode link = new ListNode();
        var current = head;
        var current2 = link;
        if(current.next == null){
            return head;
        }
        while(current != null && current.next != null){
            var node = current.next; //2
            link.next = node; //2
            link  = link.next; //2
            var temp = node.next;
            link.next = current; //1
            link = link.next;
            current = temp;
        }
        link.next = current;

        head = current2.next;
        return head;
    }
}
