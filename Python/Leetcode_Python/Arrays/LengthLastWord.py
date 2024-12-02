# Time Complexity: O(n) || Space Complexity: O(1)
def lengthOfLastWord(s: str) -> int:
    if not s:
        return -1

    count = 0
    last = len(s) - 1

    while last > 0 and s[last] == " ":
        last -= 1

    while last >= 0 and s[last] != " ":
        count += 1

    return count
