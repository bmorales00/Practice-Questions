package com.brianprojects.Leetcode.LinkedList;

public class PalindromeLL {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public boolean isPalindrome(ListNode head){
        if(head == null){return false;}

        var current = head;
        ListNode secondLL = new ListNode(current.val);
        current = current.next;

        while(current !=null){
            var second = new ListNode(current.val);
            second.next = secondLL;
            secondLL = second;
            current = current.next;
        }

        while(secondLL != null && head != null){
            if(secondLL.val != head.val){
                return false;
            }
            secondLL = secondLL.next;
            head = head.next;
        }

        return true;
    }

}
