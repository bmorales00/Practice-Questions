from typing import List, Optional

from Treenode import TreeNode


def postorderTraversal(root: Optional[TreeNode]) -> List[int]:
    if not root:
        return []

    post = []

    def dfs(root: Optional[TreeNode]) -> None:

        if not root:
            return

        dfs(root.left)
        dfs(root.right)
        post.append(root.val)

    dfs(root)
    return post
