# Time Complexity: O(n) || Space Complexity: O(1)
from typing import List


def maxProduct(nums: List[int]) -> int:
    if not nums:
        return 0
    currMax = nums[0]
    currMin = nums[0]
    res = nums[0]

    for num in nums[1:]:
        if num < 0:
            temp = currMax
            currMax = currMin
            currMin = temp

        currMax = max(num, currMax * num)
        currMin = min(num, currMin * num)
        res = max(res, currMax)
    print(res)
    return res


maxProduct([-1, -2, -9, -6])
