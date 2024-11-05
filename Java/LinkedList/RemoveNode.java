package com.brianprojects.LeetQues75.LinkedList;

public class RemoveNode {
    /*
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        var end = head;

        while(end.next != null){
            end = end.next;
        }

        var nthPosition = head;
        var distancePosition = head;

        for(var i = 0; i < n-1; i++){
            distancePosition = distancePosition.next;
            if(distancePosition == null){
                return null;
            }
        }
        while(distancePosition != end && distancePosition.next != end){
            nthPosition = nthPosition.next;
            distancePosition = distancePosition.next;
        }

        if(nthPosition == head && distancePosition == head){
            head.next = null;

        }
        else if(distancePosition == end){
            head = nthPosition.next;
        }
        else{
            var temp = nthPosition.next.next;
            nthPosition.next.next = null;
            nthPosition.next = temp;
        }
        return head;
    }

}

/*
if(head == null){
            return null;
        }
        //var first = head;
        var last = head;
        var counter = 1;
        while(last.next !=null){
            counter++;
            last = last.next;
        }

        if(counter == n){
            head = head.next;
            return head;
        }

        var p1 = head;
        var p2 = head.next;
        for(var r = counter - 1 -n; r>0; r--){
            p1 = p1.next;
            p2 = p2.next;

        }
        p1.next = p2.next;
        //p2.next = null;

        return head;
 */

/*
public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;

    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
}

 */

