from typing import List


def searchInsert(nums: List[int], target: int) -> int:
    if not nums:
        return -1

    if target <= nums[0]:
        return 0

    start = 0
    end = len(nums) - 1

    while start < end:
        mid = (end + start) // 2

        if target == nums[mid]:
            return mid

        elif target > nums[mid]:
            start = mid + 1
        else:
            end = mid - 1

    if nums[start] == target:
        return start
    elif target < nums[start]:
        return start
    else:
        return start + 1
