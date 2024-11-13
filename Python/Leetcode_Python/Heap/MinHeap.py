class MinHeap:
    def __init__(self) -> None:
        self.heap = []

    def _getParent(self, i) -> int:
        return (i - 1) // 2

    def _getLeftChild(self, i) -> int:
        return 2 * i + 1

    def _getRightChild(self, i) -> int:
        return 2 * i + 2

    def extract_min(self):
        if len(self.heap) == 0:
            return None
        min_element = self.heap[0]
        self.heap[0] = self.heap[-1]
        self.heap.pop()
        self._heapifyDown(0)

        return min_element

    def insert(self, element) -> None:
        self.heap.append(element)
        self._heapifyUp(len(self.heap) - 1)

    def _heapifyUp(self, index):
        parent = self._getParent(index)
        while index > 0 and self.heap[index] < self.heap[parent]:
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            index = parent

    def _heapifyDown(self, index):
        smallest = index
        left = self._getLeftChild(index)
        right = self._getRightChild(index)
        size = len(self.heap)

        if left < size and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < size and self.heap[right] < self.heap[smallest]:
            smallest = right

        if smallest != index:
            self.heap[index], self.heap[smallest] = (
                self.heap[smallest],
                self.heap[index],
            )
            self._heapifyDown(smallest)
