# Time Complexity: O(mxn) || Space Complexity: O(mxn)
def uniquePaths(m: int, n: int) -> int:
    if not m or not n:
        return -1

    paths = [[0 for _ in range(n + 1)] for _ in range(m + 1)]

    paths[1][1] = 1

    for i in range(1, m + 1):
        for j in range(1, n + 1):
            paths[i][j] += paths[i - 1][j] + paths[i][j - 1]
    print(paths)
    return paths[m][n]


print(uniquePaths(3, 7))
