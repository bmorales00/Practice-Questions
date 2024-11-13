from typing import Optional

from LinkedList.SinglyLL import ListNode


def removeNthFromEnd(head: Optional[ListNode], n: int) -> Optional[ListNode]:
    if not head:
        return head
    size = 0

    curr = head
    while curr:
        curr = curr.next
        size += 1
    if size == 1:
        return None
    if size == n:
        return head.next

    target = size - (n - 1)

    curr = head
    next = head.next

    nth = 2
    while (nth < target) and curr and next:
        curr = curr.next
        next = next.next
        nth += 1

    curr.next = next.next

    return head
