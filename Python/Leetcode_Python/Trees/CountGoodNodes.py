from typing import List
from Trees.Treenode import TreeNode


def goodNodes(root: TreeNode) -> int:
    if not root:
        return 0
    val = [0]

    dfs(root, val, pow(-10, 4) - 1)

    return val[0]


def dfs(root: TreeNode, val: List[int], currMax: int) -> None:
    if not root:
        return
    c = max(currMax, root.val)
    dfs(root.left, val, c)
    dfs(root.right, val, c)

    if root.val == c:
        val[0] += 1
