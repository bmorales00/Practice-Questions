from typing import List


def find132pattern(nums: List[int]) -> bool:
    if not nums:
        return False

    size = len(nums)
    if size < 3:
        return False

    stack = []

    def rec(i: int) -> bool:
        if i >= size:
            return False
        if size == 3:
            return True

        for j in range(i, size):
            if (
                not stack
                or (len(stack) == 1 and stack[-1] < nums[j])
                or (len(stack) == 2 and stack[-1] > nums[j])
            ):
                stack.append(nums[j])
                return rec(j + 1)

            stack.pop()
        return False

    return rec(0)
