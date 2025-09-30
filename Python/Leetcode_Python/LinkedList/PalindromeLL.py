# Time Complexity: O(n) || Space Complexity: O(n)
from typing import Optional
from Python.Leetcode_Python.LinkedList.SinglyLL import ListNode


def isPalindrome(head: Optional[ListNode]) -> bool:
    if not head:
        return False

    stack = []

    p1 = head

    while p1 is not None:
        stack.append(p1.val)
        p1 = p1.next

    p1 = head
    while p1 is not None:
        if p1.val != stack[-1]:
            return False
        stack.pop()
        p1 = p1.next

    return True
