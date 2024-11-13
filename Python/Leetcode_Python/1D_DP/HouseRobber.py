from typing import List


def rob(nums: List[int]) -> int:
    if not nums:
        return -1
    if len(nums) == 1:
        return nums[0]
    if len(nums) == 2:
        return max(nums[0], nums[1])

    res = max(nums[0], nums[1])
    nums[2] += nums[0]

    res = max(res, max(nums[1], nums[2]))

    for i in range(3, len(nums)):
        nums[i] = max(nums[i] + nums[i - 2], nums[i] + nums[i - 3])
        res = max(res, nums[i])

    return res
