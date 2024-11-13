# Time Complexity: O(n) || Space Complexity: O(n)
from typing import Optional
from Trees.Treenode import TreeNode

global m
m = 0


def diameterOfBinaryTree(root: Optional[TreeNode]) -> int:
    global m
    if not root:
        return 0

    res = dfs(root.left) + dfs(root.right)
    return max(m, res)


def dfs(root: Optional[TreeNode]):
    global m
    if not root:
        return 0

    left = dfs(root.left)
    right = dfs(root.right)
    m = max(m, left + right)

    return max(left, right) + 1
