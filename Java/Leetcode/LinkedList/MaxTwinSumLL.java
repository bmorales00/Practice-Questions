package com.brianprojects.Leetcode.LinkedList;

import java.util.ArrayList;

public class MaxTwinSumLL {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int pairSum(ListNode head){
        if(head == null){return 0;}
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;

        ListNode startNode = head;
        while(startNode !=null){
            list.add(startNode.val);
            startNode =startNode.next;
        }
        int s = 0;
        int e = list.size()-1;

        while(s<(list.size()/2)){
            max = Math.max(max, list.get(s++)+list.get(e--));
        }
        return max;
    }
    public int pairSum2(ListNode head){
        if(head == null){return 0;}
        ListNode head2 = new ListNode(head.val);
        ListNode startNode = head.next;
        int n = 1;
        int max = 0;
        while(startNode!=null){
            ListNode node = new ListNode(startNode.val);
            node.next = head2;
            head2 = node;
            n++;
            startNode = startNode.next;
        }
        startNode = head;
        n/=2;
        while(n>0){
            max = Math.max(max, startNode.val+head2.val);
            startNode=startNode.next;
            head2=head2.next;
            n--;
        }

        return max;
    }
}
