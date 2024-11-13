# Time Complexity: O(log n) || Space Complexity:O(1)
def hammingWeight(n: int) -> int:
    ans = 1

    while n != 1:
        ans += n % 2
        n = n // 2
    return ans
