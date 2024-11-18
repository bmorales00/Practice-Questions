# Time Complexity: O(n) || Space Complexity:O(1)
def checkValidString(s: str) -> bool:
    if not s:
        return False

    leftMin = 0
    leftMax = 0

    for ch in s:
        if ch == "(":
            leftMin += 1
            leftMax += 1
        elif ch == ")":
            leftMin -= 1
            leftMax -= 1
        else:
            leftMin -= 1
            leftMax += 1
        if leftMin < 0:
            leftMin = 0
        if leftMax < 0:
            return False

    return leftMin == 0 or leftMax == 0

