# Time Complexity: O((big-small)*dict[big-small]) or O(n*m) || Space Complexity: O(n*m)
from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None) -> None:
        self.val = val
        self.next = next


def mergeKLists(lists: List[Optional[ListNode]]) -> Optional[ListNode]:
    if not lists or len(lists) == 0:
        return []

    nodeBank = dict()

    small = 1001
    big = -1001

    for node in lists:
        while node:
            val = node.val
            if val not in nodeBank:
                nodeBank[val] = []
            nodeBank[val].append(node)
            node = node.next
            small = min(small, val)
            big = max(big, val)

    if len(nodeBank) == 0:
        return None

    head = None
    curr = head
    for num in range(small, big + 1):
        if num not in nodeBank:
            continue
        nodes = nodeBank[num]
        for node in nodes:
            if not head:
                head = node
                curr = head
                continue
            curr.next = node
            curr = curr.next
    curr.next = None

    return head
