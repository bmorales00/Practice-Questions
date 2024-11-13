# Time Complexity: O(n) || Space Complexity O(1)
def isPalindrome(s: str) -> bool:

    l = 0
    r = len(s) - 1

    while l < r:
        if not (s[l].isalpha() or s[l].isdigit()):
            l += 1
            continue
        if not (s[r].isalpha() or s[r].isdigit()):
            r -= 1
            continue
        if s[l].lower() != s[r].lower():
            return False
        l += 1
        r -= 1

    return True
