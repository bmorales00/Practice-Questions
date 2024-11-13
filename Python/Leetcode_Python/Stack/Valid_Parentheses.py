# Time Complexity: O(n) || Space Complexity: O(1)
def isValid(s: str) -> bool:
    left = []

    for l in s:
        if l == "(" or l == "[" or l == "{":
            left.append(l)
        else:
            if len(left) == 0:
                return False
            elif l == ")" and left[len(left) - 1] != "(":
                return False

            elif l == "]" and left[len(left) - 1] != "[":
                return False
            elif l == "}" and left[len(left) - 1] != "{":
                return False
            left.pop()
    return len(left) == 0
