# Time Complexity: O(n) || Space Complexity; O(n)
from typing import List


def applyOperation(nums: List[int]) -> List[int]:
    if not nums:
        return []

    i = 0
    s = len(nums)
    if s == 1:
        return nums
    left = []
    right = []

    while i < s:
        if nums[i] == 0:
            right.append(nums[i])
            i += 1
        elif i == s - 1:
            left.append(nums[i])
            i += 1
        elif nums[i] == nums[i + 1]:
            left.append(nums[i] * 2)
            right.append(0)
            i += 2
        else:
            left.append(nums[i])
            i += 1

    return left + right
