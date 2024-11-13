from typing import List, Optional
from Trees.Treenode import TreeNode


def levelOrder(root: Optional[TreeNode]) -> List[List[int]]:
    if not root:
        return [[]]

    res = []

    dfs(root, res, 0)
    return res


def dfs(root: Optional[TreeNode], res: List[List[int]], level: int) -> None:
    if not root:
        return
    if len(res) <= level:
        res.append([])

    res[level].append(root.val)
    dfs(root.left, res, level + 1)
    dfs(root.right, res, level + 1)
