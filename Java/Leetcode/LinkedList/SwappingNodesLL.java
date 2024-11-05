package com.brianprojects.Leetcode.LinkedList;

public class SwappingNodesLL {
    //Time Complexity: O(n) || Space Complexity:O(n)
    public ListNode swapNodes(ListNode head, int k){
        if(head == null){return  null;}
        ListNode current= head;
        int count = 1;
        while(current.next!=null){
            current = current.next;
            count++;
        }
        ListNode[] arr = new ListNode[count];
        current = head;
        for(int i = 0; i<arr.length;i++){
            arr[i] = current;
            current = current.next;
        }
        var temp = arr[k-1];
        arr[k-1] = arr[count-k];
        arr[count-k] = temp;
        for(int i =0; i < arr.length-1; i++){
            arr[i].next = arr[i+1];
        }
        arr[arr.length-1].next = null;
        return arr[0];
    }

}
