class MyQueue:
    def __init__(self) -> None:
        self.s1 = []
        self.s2 = []
        self.isPopping = False

    def push(self, x: int) -> None:
        if self.isPopping:
            for val in range(len(self.s1)):
                self.s2.append(self.s1.pop())
        self.s2.append(x)
        self.isPopping = False

    def pop(self) -> int:
        if not self.isPopping:
            for val in range(len(self.s2)):
                self.s1.append(self.s2.pop())
        res = self.s1.pop()
        self.isPopping = True

        return res

    def peek(self) -> int:
        if not self.isPopping:
            for val in range(len(self.s2)):
                self.s1.append(self.s2.pop())
        self.isPopping = True
        return self.s1[-1]

    def empty(self) -> bool:
        return len(self.s1) == 0 and len(self.s2) == 0
