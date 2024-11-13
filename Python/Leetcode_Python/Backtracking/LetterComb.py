# Time Coplexity: O(4^n) || Space Complexity: O(n * 4^n)
from typing import List


def letterCombination(digits: str) -> List[str]:
    if not digits or len(digits) == 0:
        return []

    phonedb = [
        [],
        [],
        ["a", "b", "c"],
        ["d", "e", "f"],
        ["g", "h", "i"],
        ["j", "k", "l"],
        ["m", "n", "o"],
        ["p", "q", "r", "s"],
        ["t", "u", "v"],
        ["w", "x", "y", "z"],
    ]
    res = []

    def backtrack(numindex: int, temp: List[str]) -> None:
        if len(temp) == len(digits):
            res.append("".join(temp))
            return

        d = int(digits[numindex])
        nums = phonedb[d]
        for i in range(len(nums)):
            temp.append(nums[i])
            backtrack(numindex + 1, temp)
            temp.pop()

    backtrack(0, [])

    return res


print(len(letterCombination("999")))
