# Time Complexity: O(n^2) || Space Complexity: O(n)
def longestPalindrome(s: str) -> str:
    if not s:
        return ""
    if len(s) == 1:
        return ""

    curr_max = -1
    ls = 0
    rs = 1
    for i in range(len(s)):
        left = i - 1
        r = i + 1
        while r < len(s) and s[i] == s[r]:
            r += 1
        while left >= 0 and s[i] == s[left]:
            left -= 1
        while left >= 0 and r < len(s):
            if s[left] != s[r]:
                break
            left -= 1
            r += 1

        r -= 1
        left += 1
        curr = (r - left) + 1
        if curr > curr_max:
            curr_max = curr
            ls = left
            rs = r + 1

    return s[ls:rs]


print(longestPalindrome("ccc"))
