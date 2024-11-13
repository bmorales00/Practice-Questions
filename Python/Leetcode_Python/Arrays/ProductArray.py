# Time Complexity: O(n) || Space Complexity:O(n)
from typing import List


def productExceptSelf(nums: List[int]) -> List[int]:
    if not nums:
        return []

    f = [1] * len(nums)
    b = [1] * len(nums)

    for i in range(1, len(nums)):
        f[i] = f[i - 1] * nums[i - 1]
    for i in range(len(nums) - 2, -1, -1):
        b[i] = b[i + 1] * nums[i + 1]

    for i in range(len(nums)):
        b[i] *= f[i]
    return b
