# Time Complexity: O(n) || Space Complexity: O(1)
from typing import List


def minOperations(nums: List[int], x: int) -> int:
    if not nums:
        return -1

    minimum = 1000000001

    total = sum(nums)

    l = 0
    r = 0

    size = len(nums)

    if x > total:
        return -1

    while r < size:

        if total >= x:
            if total == x:
                minimum = min(minimum, (size - r) + l)
            total -= nums[r]
            r += 1
        else:
            total += nums[l]
            l += 1
    while l<size:
        if total == x:
            minimum = min(minimum, (size - r) + l)
        total+=nums[l]
        l+=1

    return -1 if minimum == 1000000001 else minimum
