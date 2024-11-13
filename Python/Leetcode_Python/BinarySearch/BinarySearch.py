from typing import List


def search(nums: List[int], target: int) -> int:
    if not nums:
        return -1

    size = len(nums)
    start = 0
    end = size - 1

    while start <= end:
        mid = (end + start) // 2

        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            start = mid + 1
        else:
            end = mid - 1

    return -1
