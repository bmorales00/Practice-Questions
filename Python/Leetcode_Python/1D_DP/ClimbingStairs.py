# Time Complexity: O(n) || Space Complexity: O(n)
def climbStairs(n: int) -> int:
    if n == 1:
        return 1
    
    if n == 2:
        return 2
    dp = [0, 1, 2]

    for val in range(3, n + 1):
        dp.append(dp[val - 1] + dp[val - 2])

    return dp[n]
