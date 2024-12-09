# Time Complexity: O(n) || Space Complexity:O(1)
from typing import List


def removeDuplicates(nums: List[int]) -> int:
    if not nums:
        return -101

    p1 = 1
    p2 = p1
    k = 0
    size = len(nums)

    while p2 < size:
        while p2 < size and nums[p2] == nums[p1 - 1]:
            p2 += 1
        nums[p1], nums[p2] = nums[p2], nums[p1]
        p1 += 1
        p2 += 1

    while p1 < size:
        nums[p1] = -101
        k += 1

    return size - k
