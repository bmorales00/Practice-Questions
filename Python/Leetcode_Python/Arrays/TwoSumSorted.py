# Time Complexity: O(n) || Space Complexity:O(1)
from typing import List


def twoSum(nums: List[int], target: int) -> List[int]:
    if not nums:
        return []

    p1 = 0
    p2 = len(nums) - 1
    while p1 < p2:
        if nums[p1] + nums[p2] < target:
            p1 += 1
        elif nums[p1] + nums[p2] > target:
            p2 -= 1
        else:
            return [p1 + 1, p2 + 1]

    return []
