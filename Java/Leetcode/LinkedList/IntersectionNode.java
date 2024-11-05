package com.brianprojects.Leetcode.LinkedList;

import java.util.HashMap;

public class IntersectionNode {
    // Time Complexity: O(n) || Space Complexity: O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        HashMap<ListNode, Integer> map = new HashMap<>();
        var currentA = headA;
        int skippedA = 0;
        var currentB = headB;
        int skippedB = 0;
        while(currentA != null){
            map.put(currentA, skippedA++);
            currentA = currentA.next;
        }
        while(currentB !=null){
            if(map.containsKey(currentB)){
                skippedA = map.get(currentB);
                return currentB;
            }
            skippedB++;
            currentB = currentB.next;
        }



        return null;
    }

}

/*              Time Complexity: O(m*n) | Space Complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode head){
        int skippedA = 0;
        int skippedB;

        ListNode currentA = headA;
        while(currentA !=null){
            ListNode currentB = headB;
            while(currentB != null){
                skippedB= 0;
                if(currentA == currentB){
                    return currentA;
                }
                skippedB++;
                currentB = currentB.next;
            }
            skippedA++;
            currentA = currentA.next;
        }
        return null;
    }
     */