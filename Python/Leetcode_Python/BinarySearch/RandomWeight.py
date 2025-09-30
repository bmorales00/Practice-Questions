# WORK ON THIS PROBLEM
import random
from typing import List


class Solution:
    def __init__(self, w: List[int]) -> None:
        self.w = []
        for i in w:
            if len(self.w) == 0:
                self.w.append(i)
            else:
                self.w.append(self.w[-1] + i)

    def pickIndex(self) -> int:
        size = len(self.w)
        s = 0
        e = size - 1

        rand = random.randint(1, self.w[-1])
        while s != e:
            mid = (e + s) // 2
            val = self.w[mid]
            if rand == val:
                return mid
            if rand <= self.w[s]:
                return s
            if rand == self.w[e]:
                return e
            if rand > self.w[s] and rand < val:
                e = mid - 1
            elif rand < self.w[e] and rand > val:
                s = mid + 1
         
        if rand > self.w[s]:
            return s+1
        else: 
            return s-1
