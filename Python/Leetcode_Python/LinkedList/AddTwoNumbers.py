# Time Complexity: O(n) || Space Complexity:O(n)
from typing import Optional

from LinkedList import SinglyLL


def addTwoNumbers(
    l1: Optional[SinglyLL.ListNode], l2: Optional[SinglyLL.ListNode]
) -> Optional[SinglyLL.ListNode]:
    if not l1 or not l2:
        return None

    l1_map = []
    l2_map = []

    while l1:
        l1_map.append(str(l1.val))
        l1 = l1.next
    while l2:
        l2_map.append(str(l2.val))
        l2 = l2.next

    l1_map.reverse()
    l2_map.reverse()

    x = "".join(map(str, l1_map))
    y = "".join(map(str, l2_map))

    x = int(x)
    y = int(y)

    z = x + y
    z = str(z)

    head = SinglyLL.ListNode()
    curr = head.next
    for i in z:
        val = int(i)
        head.next = SinglyLL.ListNode(val)
        head.next.next = curr
        curr = head.next

    return head.next
