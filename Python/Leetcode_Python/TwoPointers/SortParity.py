# Time Complexity: O(n) || Space Complexity: O(1)
from typing import List


def sortArrayByParity(nums: List[int]) -> List[int]:
    if not nums:
        return []

    p1 = -1
    p2 = 0
    size = len(nums)
    while p2 < size:
        if nums[p2] % 2 == 0:
            p1 += 1
            nums[p1], nums[p2] = nums[p2], nums[p1]
        p2 += 1

    return nums
