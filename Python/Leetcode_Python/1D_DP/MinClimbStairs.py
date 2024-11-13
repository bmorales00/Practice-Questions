# Time Complexity: O(n) || Space Complexity:O(1)
from typing import List


def minCostClimbingStairs(nums: List[int]) -> int:
    if not nums:
        return 0

    size = len(nums)

    if size == 1:
        return nums[0]
    if size == 2:
        return min(nums[0], nums[1])

    for i in range(2, size):
        nums[i] += min(nums[i - 1], nums[i - 2])

    return min(nums[size - 1], nums[size - 2])
