# Time Complexity: O(n) || Space Complexity: O(n)
from typing import List


def asteroidCollision(asteroids: List[int]) -> List[int]:
    if not asteroids:
        return []

    stack = []

    for asteroid in asteroids:
        if not stack:
            stack.append(asteroid)
            continue

        if stack[-1] < 0 or (stack[-1] > 0 and asteroid > 0):
            stack.append(asteroid)
            continue

        if stack and abs(stack[-1]) == abs(asteroid):
            stack.pop()
            continue

        while (
            stack and asteroid < 0 and stack[-1] > 0 and abs(asteroid) > abs(stack[-1])
        ):
            stack.pop()

        if stack and asteroid < 0 and stack[-1] > 0 and abs(stack[-1]) == abs(asteroid):
            stack.pop()
        elif not stack or (
            stack and stack[-1] // abs(stack[-1]) == asteroid // abs(asteroid)
        ):
            stack.append(asteroid)

    return stack
