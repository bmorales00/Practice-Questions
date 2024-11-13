from typing import List
import heapq


class KthLargest:

    def __init__(self, k: int, nums: List[int]) -> None:
        self.max_pq = self.fill(nums)
        self.k = k

    def fill(self, nums: List[int]) -> List[int]:
        res = []

        for val in nums:
            heapq.heappush(res, val)
            if len(res) > self.k:
                heapq.heappop(res)

        return res

    def add(self, val: int) -> int:
        heapq.heappush(self.max_pq, val)
        if len(self.max_pq) > self.k:
            heapq.heappop(self.max_pq)
        return self.max_pq[0]
