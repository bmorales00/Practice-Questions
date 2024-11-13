# Time Complexity: O(n) || Space Complexity: O(1)
from SinglyLL import ListNode


def reverseList(head: Optional[ListNode]) -> Optional[ListNode]:
    if head is None:
        return None

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
