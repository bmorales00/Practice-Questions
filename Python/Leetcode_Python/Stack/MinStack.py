# Time Complexity: O(1) for all methods || Space Complexity: O(n)
class Node:
    def __init__(self, val: int, smallVal: int) -> None:
        self.val = val
        self.smallVal = smallVal


class MinStack:
    def __init__(self) -> None:
        self.stack = []
        self.minimum = pow(2, 31) - 1

    def push(self, val: int) -> None:
        self.minimum = min(self.minimum, val)
        node = Node(val, self.minimum)
        self.stack.append(node)

    def pop(self) -> None:
        self.stack.pop()
        if len(self.stack) == 0:
            self.minimum = pow(2, 31) - 1
        else:
            node = self.stack[-1]
            self.minimum = node.smallVal

    def top(self) -> int:
        node = self.stack[-1]
        return node.val

    def getMin(self) -> int:
        node = self.stack[-1]
        return node.smallVal


print(pow(2, 31) + 1)
