# Time Complexity: O(n) || Space Complexity: O(n)
from typing import List


def longestConsecutive(nums: List[int]) -> int:
    if not nums:
        return 0
    if len(nums) == 1:
        return 1

    container = set(nums)
    visited = set()

    longest = 1
    for val in container:
        if val in visited:
            continue
        left = val - 1
        count = 1
        while left in container:
            visited.add(left)
            count += 1
            left -= 1
        right = val + 1
        while right in container:
            visited.add(right)
            count += 1
            right += 1
        visited.add(val)
        longest = max(longest, count)

    return longest
