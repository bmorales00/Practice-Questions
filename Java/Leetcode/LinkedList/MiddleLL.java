package com.brianprojects.Leetcode.LinkedList;

public class MiddleLL {

    //Time Complexity: O(n) || Space Complexity: O(1)
    public ListNode middleNode(ListNode head){
        if(head == null){return null;}
        if(head.next == null ){return head;}

        int mid = 1;
        ListNode current = head;
        while(current.next != null){
            current = current.next;
            mid++;
        }
        mid/=2;
        current= head;
        while(mid>0){
            current = current.next;
            mid--;
        }
        return current;
    }

}
