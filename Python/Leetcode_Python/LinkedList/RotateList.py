from typing import Optional
from SinglyLL import ListNode


def rotateRight(head:Optional[ListNode], k:int)-> Optional[ListNode]:
    if not head:
        return None
    if not head.next:
        return head

    size = 0

    curr = head

    while curr:
        size+=1
        curr = curr.next

    node = k%size
    if node == 0:
        return head
    
    stopper = size

    p1 = None
    p2 = head
    while stopper != node:
        p1 = p2
        p2 = p2.next
        stopper-=1

    p1.next = None
    curr = p2

    while curr.next:
        curr = curr.next
    curr.next = head
    head = p2
    return head
        
