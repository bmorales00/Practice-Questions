# Time Complexity: O(n) || Space Complexity: O(1)
from typing import Optional
from SinglyLL import ListNode


def hasCycle(head: Optional(ListNode)) -> bool:
    if head is None or head.next is None:
        return False

    slow = head

    fast = head

    while fast is not None and fast.next is not None:
        slow = slow.next
        fast = fast.next.next

        if slow is fast:
            return True

    return False
