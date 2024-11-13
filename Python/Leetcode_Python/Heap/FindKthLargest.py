# Time Complexity: O(n) || Space Complexity: O(1)
from typing import List
import heapq


def findKthLargest(nums: List[int], k: int) -> int:
    if not nums:
        return 0

    for i in range(len(nums)):
        nums[i] *= -1

    heapq.heapify(nums)

    for t in range(1, k):
        heapq.heappop(nums)

    return nums[0] * -1


def _findKthLargest(nums: List[int], k: int) -> int:
    def pivot(nums: List[int], k: int) -> int:
        piv = len(nums) // 2
        val = nums[piv]

        left, mid, right = [], [], []

        for num in nums:
            if val > num:
                right.append(num)
            elif val < num:
                left.append(left)
            else:
                mid.append(num)

        if k <= len(left):
            return pivot(left, k)

        if len(left) + len(mid) < k:
            return pivot(right, k - len(left) - len(mid))

        return val

    return pivot(nums, k)
