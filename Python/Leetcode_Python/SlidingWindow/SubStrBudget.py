# Time Complexity: O(n) || Space Complexity:O(n)
def equalSubString(s: str, t: str, maxCost: int) -> int:
    if len(s) != len(t):
        return 0

    l = 0
    r = 0

    cost = 0
    maxSub = 0

    diff = []

    for i in range(len(s)):
        ch1 = ord(s[i])
        ch2 = ord(t[i])
        diff.append(abs(ch1 - ch2))

    while r < len(diff):
        if diff[r] + cost <= maxCost:
            cost += diff[r]
            maxSub = max(maxSub, (r - l) + 1)
            r += 1
        else:
            if l == r:
                l += 1
                r += 1
            else:
                cost -= diff[l]
                l += 1

    return maxSub
