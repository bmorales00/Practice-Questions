# Time Complexity: O(n) || Space Complexity: O(1)
from typing import Optional

from Python.Leetcode_Python.LinkedList.SinglyLL import ListNode


def middleNode(head: Optional[ListNode]) -> Optional[ListNode]:
    if not head:
        return ListNode()

    p1 = head
    count = 0

    while p1 is not None:
        count += 1
        p1 = p1.next

    i = 0
    p1 = head

    while i != count // 2:
        i += 1
        p1 = p1.next

    return p1
