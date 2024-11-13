from typing import List


def findDuplicate(nums: List[int]) -> int:
    if not nums:
        return 0

    slow = fast = 0

    while True:
        slow = nums[slow]
        fast = nums[nums[fast]]

        if slow == fast:
            break

    curr = slow
    head = 0

    while curr != head:
        head = nums[head]
        curr = nums[curr]
    return curr
