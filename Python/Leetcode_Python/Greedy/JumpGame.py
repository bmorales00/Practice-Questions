# Time Complexity: O(n) || Space Complexity:O(n)
from typing import List


def canJump(nums: List[int]) -> bool:
    if not nums:
        return False
    size = len(nums)
    dp = [False] * size
    dp[size - 1] = True
    source = size - 1

    for i in range(size - 2, -1, -1):
        print(i)
        if nums[i] == 0:
            continue
        if nums[i] >= (size - 1) - i or nums[i] >= source - i:
            dp[i] = dp[size - 1]
            source = i
        else:
            dp[i] = dp[i + 1]

    print(dp)
    return dp[0]


canJump([3, 3, 1, 0, 4])
