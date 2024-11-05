package com.brianprojects.Leetcode.LinkedList;

import java.util.Arrays;

public class SortList {
    //Time Complexity: O(n log n) || Space Complexity: o(1)
    public ListNode sortList(ListNode head){
        if(head == null){return null;}
        int size = 0;
        var current = head;
        while(current!=null){
            current = current.next;
            size++;
        }
        int[] array = new int[size];
        current =head;
        int i=0;
        while(current!=null){
            array[i++] = current.val;
            current = current.next;
        }
        Arrays.sort(array);
        current = head;
        for (int k : array) {
            current.val = k;
            current = current.next;
        }
        return head;
    }
    public ListNode sortList2(ListNode head){
        ListNode curr = head;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(curr != null){
            if(curr.val > max){
                max = curr.val;
            }
            if(curr.val < min){
                min = curr.val;
            }
            curr = curr.next;
        }
        int size = max - min + 1;
        int[] a = new int[size];
        curr = head;
        while(curr != null){
            a[curr.val - min]++;
            curr = curr.next;
        }
        curr = head;
        int i = 0;
        while(curr != null){
            while(a[i] == 0){
                i++;
            }
            curr.val = i + min;
            a[i]--;
            curr = curr.next;
        }
        return head;
    }
}

