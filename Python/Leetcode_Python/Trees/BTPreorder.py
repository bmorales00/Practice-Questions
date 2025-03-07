from typing import List, Optional
from Treenode import TreeNode


def preorderTraversal(root: Optional[TreeNode]) -> List[int]:
    if not root:
        return []

    pre = []

    def dfs(root: Optional[TreeNode]) -> None:
        if not root:
            return

        pre.append(root.val)
        dfs(root.left)
        dfs(root.right)

    dfs(root)

    return pre
