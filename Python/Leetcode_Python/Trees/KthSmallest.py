# Time Complexity: O(n) || Space Complexity: O(n)
from typing import Optional, List

from Trees.Treenode import TreeNode


def kthSmallest(root: Optional[TreeNode], k: int) -> int:
    if not root:
        return -1

    inorder = []
    dfs(root, inorder)

    return inorder[k - 1]


def dfs(root: TreeNode, inorder: List[int]) -> None:
    if not root:
        return

    dfs(root.left, inorder)
    inorder.append(root.val)
    dfs(root.right, inorder)
