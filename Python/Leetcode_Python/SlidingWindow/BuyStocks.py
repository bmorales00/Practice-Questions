# Time Complexity: O(n) || Space Complexity O(1)
def maxProfit(prices: List[int]) -> int:
    if prices is None:
        return 0
    buy = prices[0]
    sell = 0

    for price in prices:
        buy = min(buy, price)
        sell = max(sell, price - buy)

    return sell
