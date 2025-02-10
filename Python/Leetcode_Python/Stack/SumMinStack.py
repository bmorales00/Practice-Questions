# Time COmplexity: O(n) || Space COmplexity: O(n)
from typing import List


def sumSubarrayMin(arr: List[int]) -> int:
    if not arr:
        return -1

    res = arr[0]

    total = arr[0]

    stack = [arr[0]]
    occur = [1]

    for i in range(1, len(arr)):
        val = arr[i]
        count = 1

        while stack and val < stack[-1]:
            total -= stack.pop() * occur.pop()
            count += 1
        stack.append(val)
        occur.append(count)
        total += val * count
        res += total

    return res % 1000000007
