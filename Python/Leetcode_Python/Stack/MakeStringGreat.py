def makeGood(s: str) -> str:
    if not s:
        return ""

    stack = []

    for char in s:
        if len(stack) == 0:
            stack.append(char)
            continue
        l1 = ord(stack[-1])
        l2 = ord(char)

        if abs(l1 - l2) == 32:
            stack.pop()
        else:
            stack.append(char)

    return "".join(stack)
