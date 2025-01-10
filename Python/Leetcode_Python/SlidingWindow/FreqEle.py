# Time Complexity: O(n) || Space Complexity: O(1)
from typing import List


def maxFrequency(nums:List[int], k:int)->int:
    if not nums:
        return -1

    if len(nums)==1:
        return 1

    nums.sort()
    l = 0
    r = 0

    total = nums[l]
    res  = 1
    while r < len(nums):
        if nums[r] * ((r-l)+1) <= total+k:
            r+=1
            total+=nums[r]
        else:
            total-=nums[l]
            l+=1
        res = max(res, (r-l)+1)
    return res


