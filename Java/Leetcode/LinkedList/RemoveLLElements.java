package com.brianprojects.Leetcode.LinkedList;

public class RemoveLLElements {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public ListNode removeElements(ListNode head, int val){
        if(head == null){return  null;}
        var current = head;
        var next = current.next;
        if(current.val == val){
            while(next!= null && next.val == val){
                next = next.next;
            }
            head= next;
            current = head;
        }
        if(current != null){
            next = current.next;
        }
        while(next != null){
            if(next.val == val){
                var temp = next;
                while(temp != null && temp.val == val){
                    temp = temp.next;
                }
                current.next= temp;
                next = temp;
            }
            if(next != null){
                current = current.next;
                next =  next.next;
            }
        }
        return head;
    }
}

/*
ListNode node = new ListNode(0), tmp = head, cur = node;

        while (tmp != null) {
            if (tmp.val != val) {
                cur.next = tmp;
                cur = tmp;
            }

            tmp = tmp.next;
        }

        if (cur != tmp) {
            cur.next = null;
        }


        return node.next;
 */