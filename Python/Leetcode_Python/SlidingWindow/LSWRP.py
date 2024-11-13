# Time Complexity: O(n) || Space Complexity(n)
from typing import Dict


def lengthOfLongestSubString(s: str) -> int:
    if not s:
        return 0
    if len(s) == 1:
        return 1
    visited = dict()

    visited[s[0]] = 0
    most = 0
    j = 0
    for i in range(1, len(s)):
        if s[i] in visited:
            most = max(most, i - j)
            removeChars(j, visited[s[i]], s, visited)
            j = visited[s[i]] + 1

        visited[s[i]] = i
    most = max(most, len(s) - j)
    return most


def removeChars(j: int, i: int, s: str, visited: Dict) -> None:
    while j < i:
        visited.pop(s[j])
        j += 1
