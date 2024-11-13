from typing import List


class MaxHeap:
    def __init__(self, maxheap: List[int] = list()) -> None:
        self.maxHeap = self.__fill(maxheap)

    def __fill(self, maxheap: List[int]) -> List[int]:
        if len(maxheap) == 0:
            return maxheap
        for i in range(len(maxheap), -1, -1):
            self.maxHeapify(maxheap, i)
        return maxheap

    def print(self) -> None:
        print(self.maxHeap)

    def _getParent(self, index) -> int:
        return (index - 1) // 2

    def _getLeftChild(self, index) -> int:
        return (2 * index) + 1

    def _getRightChild(self, index) -> int:
        return (2 * index) + 2

    def _getSize(self) -> int:
        return len(self.maxHeap)

    def insert(self, value: int) -> None:
        self.maxHeap.append(value)
        k = self._getSize() - 1
        p = self._getParent(k)
        while k > 0 and self.maxHeap[k] > self.maxHeap[p]:
            self.maxHeap[k], self.maxHeap[p] = self.maxHeap[p], self.maxHeap[k]
            k = p
            p = self._getParent(k)

    def maxHeapify(self, maxHeap: List[int], i: int) -> None:
        largest = i
        left = (2 * i) + 1
        right = (2 * i) + 2
        s = len(maxHeap)
        if left < s and maxHeap[left] > maxHeap[largest]:
            largest = left
        if right < s and maxHeap[right] > maxHeap[largest]:
            largest = right

        if largest != i:
            maxHeap[i], maxHeap[largest] = maxHeap[largest], maxHeap[i]
            self.maxHeapify(maxHeap, largest)
