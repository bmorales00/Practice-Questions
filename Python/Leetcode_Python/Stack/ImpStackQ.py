from collections import deque


class MyStack:
    def __init__(self) -> None:
        self.queue = deque()

    def empty(self) -> bool:
        return len(self.queue) == 0

    def push(self, x: int) -> None:
        self.queue.append(x)

    def top(self) -> int:
        return self.queue[-1]

    def pop(self) -> int:
        return self.queue.pop()
