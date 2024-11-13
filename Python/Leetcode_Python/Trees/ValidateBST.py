# Time Complexity: O(n) || Space Complexity: o(n)
from typing import Optional

from Trees.Treenode import TreeNode


def isValidBST(root: Optional[TreeNode]) -> bool:
    if not root:
        return True

    inorder = []

    dfs(root, inorder)

    if len(inorder) == 1:
        return True

    for i in range(1, len(inorder)):
        if inorder[i - 1] >= inorder[i]:
            return False

    return True


def dfs(root: TreeNode, inorder: List[int]) -> None:
    if not root:
        return

    dfs(root.left, inorder)
    inorder.append(root.val)
    dfs(root.right, inorder)
