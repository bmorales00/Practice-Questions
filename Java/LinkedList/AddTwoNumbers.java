package com.brianprojects.LeetQues75.LinkedList;

public class AddTwoNumbers {
    /*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode l3 = new ListNode(0);
        var pointer3 = l3;


        var pointer1 = l1;
        var pointer2 = l2;
        var remainder = 0;


        while(pointer1 != null || pointer2 != null){
            if(pointer1 == null){
                pointer1 = new ListNode(0);
            }
            if(pointer2 == null){
                pointer2 = new ListNode(0);
            }
            if(pointer1.val + pointer2.val >= 10){
                pointer3.next = new ListNode((pointer1.val + pointer2.val)%10 + remainder);
                remainder = (pointer1.val + pointer2.val)/10;
            }
            else{
                pointer3.next = new ListNode((pointer1.val+pointer2.val + remainder)%10);
            }
            pointer1 =pointer1.next;
            pointer2 = pointer2.next;
            pointer3 = pointer3.next;
        }
        if(remainder != 0){
            pointer3.next = new ListNode(remainder);
        }

        return l3.next;
    }
}
