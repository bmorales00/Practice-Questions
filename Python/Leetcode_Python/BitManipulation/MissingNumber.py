from typing import List


def missingNumber(nums: List[int]) -> int:
    n = len(nums)

    arr = [0] * (n + 1)

    for num in nums:
        arr[num] += 1

    for i in range(n + 1):
        if arr[i] == 0:
            return i

    return 0
