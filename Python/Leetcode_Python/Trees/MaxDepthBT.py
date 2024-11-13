# Time Complexity: O(n) || Space Complexity: O(n)
from typing import Optional
from Treenode import TreeNode


def maxDepth(root: Optional[TreeNode]) -> int:
    return dfs(root, 0)


def dfs(root: Optional[TreeNode], count: int) -> int:
    if not root:
        return count
    return max(dfs(root.left, count + 1), dfs(root.right, count + 1))
