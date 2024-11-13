# Time Complexity: O(2^n) || Space Complexity: O(n)
from typing import List


def findTargetSumWays(nums: List[int], target: int) -> int:
    if not nums:
        return 0
    memo = {}

    def dfs(index: int, total: int) -> int:
        if (index, total) in memo:
            return memo[(index, total)]
        if index == len(nums) and total == target:
            return 1

        if index >= len(nums):
            return 0
        p_subset = dfs(index + 1, total + nums[index])
        n_subset = dfs(index + 1, total + (-1 * nums[index]))

        memo[(index, total)] = p_subset + n_subset
        return memo[(index, total)]

    return dfs(0, 0)


print(findTargetSumWays([1, 1, 1, 1, 1], 3))
