# Time Complexity: O(n) || Space Complexity: O(1)
from Python.Leetcode_Python.LinkedList.SinglyLL import ListNode


def mergeInBetween(list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
    if not list1 or not list2:
        return None

    p1 = list1
    p2 = list1

    pt = list2

    for i in range(0, a - 1):
        p1 = p1.next
    for i in range(0, b):
        p2 = p2.next
    while pt.next is not None:
        pt = pt.next

    p1.next = list2
    pt.next = p2.next
    p2.next = None

    return list1
