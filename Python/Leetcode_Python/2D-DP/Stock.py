from typing import List


def maxProfit(prices: List[int]) -> int:
    if not prices:
        return 0
    if len(prices) <= 1:
        return 0

    curr_max = 0

    def dfs(index: int, is_buying: bool) -> int:
        if index > len(prices):
            return 0
        if is_buying:
            if index + 1 >= len(prices):
                return prices[index]
            total = dfs(index + 1, False) - prices[index]
        else:
            if index + 2 >= len(prices):
                return prices[index]
            total = prices[index] + dfs(index + 2, True)
        return total

    for i in range(len(prices) - 1):
        curr_max = max(curr_max, dfs(i, True))
    return curr_max


print(maxProfit([1, 2, 3, 0, 2]))
