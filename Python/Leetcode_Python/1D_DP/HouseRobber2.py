# Time Complexity: O(n) || Space Complexity: O(n)
from typing import List


def robber(nums: List[int]) -> int:
    if not nums:
        return -1
    size = len(nums)
    if size == 1:
        return nums[0]
    if size == 2:
        return max(nums[0], nums[1])
    if size == 3:
        return max(nums[0], max(nums[1], nums[2]))
    if size == 4:
        return max(nums[2] + nums[0], nums[1] + nums[3])

    copy = nums.copy()
    nums[2] += nums[0]
    res = max(nums[0], max(nums[1], nums[2]))

    for i in range(3, size - 1):
        nums[i] += max(nums[i - 2], nums[i - 3])
        res = max(res, nums[i])
    copy[3] += copy[1]
    res = max(res, copy[3])
    for i in range(4, size):
        copy[i] += max(copy[i - 2], copy[i - 3])
        res = max(res, copy[i])
    return res


robber([6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3])
