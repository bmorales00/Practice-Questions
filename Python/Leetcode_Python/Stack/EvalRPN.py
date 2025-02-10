# Time Complexity: O(n) || Space Complexity:O(n)
from typing import List


def evalRPN(tokens: List[str]) -> int:
    if not tokens:
        return 0

    stack = []

    for token in tokens:
        if token == "/":
            r = stack.pop()
            l = stack.pop()
            if l < 0 and r >= 0:
                stack.append((-l // r) * -1)
            elif l >= 0 and r < 0:
                stack.append((l // -r) * -1)
            else:
                stack.append(int(token))
        elif token == "+":
            r = stack.pop()
            l = stack.pop()
            stack.append(l + r)
        elif token == "-":
            r = stack.pop()
            l = stack.pop()
            stack.append(l - r)
        elif token == "*":
            r = stack.pop()
            l = stack.pop()
            stack.append(l * r)
        else:
            stack.append(int(token))
    return stack.pop()
