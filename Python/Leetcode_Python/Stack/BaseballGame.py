from typing import List


def calPoints(opertaions: List[str]) -> int:
    if not opertaions:
        return -1

    res = []

    for op in opertaions:
        if op == "C":
            res.pop()
        elif op == "D":
            res.append(res[-1] * 2)
        elif op == "+":
            res.append(res[-1] + res[-2])
        else:
            res.append(int(op))
    return sum(res)
