# Time Complexity: O(n) || Space Complexity: O(n)
from typing import Optional


class Node:
    def __init__(self, x: int, next: "Node" = None, random: "Node" = None) -> None:
        self.val = int(x)
        self.next = next
        self.random = random


def copyRandomList(head: Optional[Node]) -> Optional[Node]:
    if not head:
        return None

    size = 0
    current = head

    while current:
        size += 1
        current = current.next
    current = head

    nodes = [Node] * size
    mapper = dict()
    res = Node(-1)
    temp = res
    i = 0
    while current:
        mapper[id(current)] = i
        n = Node(current.val)
        temp.next = n
        temp = temp.next
        current = current.next
        nodes[i] = temp
        i += 1

    current = head
    temp = res.next
    while current:
        if not current.random:
            current = current.next
            temp = temp.next
            continue
        i = mapper[id(current.random)]
        temp.random = nodes[i]
        current = current.next
        temp = temp.next

    return res.next
