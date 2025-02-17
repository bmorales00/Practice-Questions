from typing import List


def minSubArrayLen(target: int, nums: List[int]) -> int:
    if not nums:
        return -1

    l = 0
    r = 0

    total = 0

    minimum = 1000000009

    while r < len(nums):
        val = nums[r]
        if total < target:
            total += val
            r += 1
        else:
            minimum = min(minimum, (r - l) + 1)
            total -= nums[l]
            l += 1
            if l > r:
                r = l

    return minimum
