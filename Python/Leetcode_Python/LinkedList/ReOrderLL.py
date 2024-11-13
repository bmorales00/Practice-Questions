from typing import Optional
from LinkedList.SinglyLL import ListNode


def reorderList(head: Optional[ListNode]) -> None:
    if not head:
        return

    size = 0

    curr = head

    while curr is not None:
        curr = curr.next
        size += 1

    if size == 1 or size == 2:
        return
    curr = head
    mid = head
    i = 0
    while i < (size // 2) and mid is not None:
        mid = mid.next
        i += 1
    mid = reverseLL(mid)

    while curr.next is not None and mid.next is not None:
        temp1 = curr.next
        temp2 = mid.next
        curr.next = mid
        curr.next.next = temp1
        curr = temp1
        mid = temp2

    if mid.next is not None:
        curr.next = mid
        mid.next.next = None

    return head


def reverseLL(head: Optional[ListNode]) -> Optional[ListNode]:
    if not head:
        return

    curr = head
    next = curr.next

    while next is not None:
        temp = next.next
        next.next = curr
        curr = next
        next = temp

    head.next = None
    head = curr
    return head
