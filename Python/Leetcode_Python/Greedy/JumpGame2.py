# Time Complexity: O(n) || Space Complexity: O(n)
from typing import List


def jump(nums: List[int]) -> int:
    if not nums:
        return 0

    jumps = 0
    end = 0
    farth = 0

    for i in range(len(nums) - 1):
        farth = max(farth, i + nums[i])
        print(f"Farth: {farth}, Jump: {jumps}, end:{end}, i:{i}")
        if i == end:
            jumps += 1
            end = farth
    return jumps


jump([1, 2, 1, 1, 1])
