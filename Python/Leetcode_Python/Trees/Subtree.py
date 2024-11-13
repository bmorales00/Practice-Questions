# Time Complexity: O(n)i || Space Complexity: O(n)
from typing import Optional

from Trees.Treenode import TreeNode


def isSubTree(root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
    if not root and not subRoot:
        return True
    if (root and not subRoot) or (not root and subRoot):
        return False
    queue = []
    queue.append(root)

    while not queue:
        curr = queue.pop()
        if curr.val == subRoot.val and dfs(curr, subRoot):
            return True

        if curr.left:
            queue.append(curr.left)
        if curr.right:
            queue.append(curr.right)
    return False


def dfs(root: Optional[TreeNode], subRoot: Optional[TreeNode]):
    if not root and not subRoot:
        return True
    if (root and not subRoot) or (not root and subRoot) or root.val != subRoot.val:
        return False
    return dfs(root.left, subRoot.left) and dfs(root.right, subRoot.right)
