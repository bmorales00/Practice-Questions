from typing import List, Optional
from Treenode import TreeNode


def inorderTraversal(root: Optional[TreeNode]) -> List[int]:
    if not root:
        return []

    inOrder = []

    def dfs(root: Optional[TreeNode]) -> None:
        if not root:
            return

        dfs(root.left)
        inOrder.append(root.val)
        dfs(root.right)

    dfs(root)

    return inOrder
