# Time Complexity: O(n) || Space Complexity: O(1)
def validPalindrome(s: str) -> bool:
    if not s:
        return False
    if len(s) == 1:
        return True
    if len(s) == 2 and s[0] == s[1]:
        return True

    p1 = 0
    p2 = len(s) - 1
    temp1 = 0
    temp2 = 0
    temp3 = 0
    temp4 = 0

    while p1 <= p2:
        if s[p1] == s[p2]:
            p1 += 1
            p2 -= 1
        elif s[p1] != s[p2]:
            temp1 = p1 + 1
            temp2 = p2

            temp3 = p1
            temp4 = p2 - 1
            while temp1 <= temp2 and s[temp1] == s[temp2]:
                temp1 += 1
                temp2 -= 1
            while temp3 <= temp4 and s[temp3] == s[temp4]:
                temp3 += 1
                temp4 -= 1
            break

    return p1 > p2 or temp1 > temp2 or temp3 > temp4
