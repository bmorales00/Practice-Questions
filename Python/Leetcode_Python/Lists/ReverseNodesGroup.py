# Time Complexity: O(n) || Space Complexity: O(n)
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None) -> None:
        self.val = val
        self.next = next


def reverseKGroup(head: Optional[ListNode], k: int) -> Optional[ListNode]:
    if not head:
        return None
    if k == 1:
        return head

    refList = []

    curr = head

    while curr:
        refList.append(curr)
        curr = curr.next

    start = 0
    end = k - 1

    while end < len(refList):
        tempstart = start
        tempend = end

        while tempstart < tempend:
            temp = refList[tempstart]
            refList[tempstart] = refList[tempend]
            refList[tempend] = temp
            tempstart += 1
            tempend -= 1
        start += k
        end += k

    for i in range(len(refList) - 1):
        refList[i].next = refList[i + 1]

    refList[-1].next = None

    return refList[0]
