from typing import Optional


class Minheap:
    def __init__(self) -> None:
        self.heap = []

    def __getParent(self, i) -> int:
        return (i - 1) // 2

    def __getLeftChild(self, i) -> int:
        return i * 2 + 1

    def __getRightChild(self, i) -> int:
        return i * 2 + 2

    def insert(self, element) -> None:
        self.heap.append(element)
        self.__heapifyUp(-1)

    def getMin(self) -> Optional[int]:
        if len(self.heap) == 0:
            return None
        min_element = self.heap[0]

        self.heap[0] = self.heap[-1]
        self.heap.pop()
        self.__heapifyDown(0)

        return min_element

    def __heapifyDown(self, index: int) -> None:

        smallest = index
        left = self.__getLeftChild(smallest)
        right = self.__getRightChild(smallest)
        size = len(self.heap)

        if left < size and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < size and self.heap[right] < self.heap[smallest]:
            smallest = right

        if smallest != index:
            self.heap[smallest], self.heap[index] = (
                self.heap[index],
                self.heap[smallest],
            )
            self.__heapifyDown(smallest)

    def __heapifyUp(self, index: int) -> None:

        parent = self.__getParent(index)

        while index > 0 and self.heap[parent] > self.heap[index]:
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            index = parent
            parent = self.__getParent(index)
