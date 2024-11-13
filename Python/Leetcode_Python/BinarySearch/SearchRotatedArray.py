# Time Complexity: O(log n) || Space Complexity: O(1)
from typing import List


def search(nums: List[int], target: int) -> int:
    if not nums:
        return -1
    if len(nums) == 1 and target != nums[0]:
        return -1
    if len(nums) == 1 and target == nums[0]:
        return 0

    start = 0
    end = len(nums) - 1
    while start < end:
        mid = (start + end) // 2
        if nums[start] == target:
            return start
        if nums[end] == target:
            return end
        if nums[mid] == target:
            return mid

        if (
            (target < nums[mid] and nums[mid] < nums[end])
            or (target > nums[mid] and target > nums[end] and nums[mid] < nums[end])
            or (target < nums[mid] and target > nums[end])
        ):
            end = mid - 1
        else:
            start = mid + 1

    return -1
