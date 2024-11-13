# Time Complexity: O(n) || Space Complexity: O(n)
from typing import Optional

from Trees.Treenode import TreeNode


def isBalanced(root: Optional[TreeNode]) -> bool:
    if not root:
        return True
    left = isBalanced(root.left)
    right = isBalanced(root.right)
    if isLeaf(root):
        root.val = 1
        return True
    elif not root.left or not root.right:
        root.val = 0

    res = False
    if not root.left:
        if root.right.val > root.val:
            res = root.right.val - root.val <= 1
        else:
            res = root.val - root.right.val <= 1

        root.val = max(root.val, root.right.val) + 1
    elif not root.right:
        if root.left.val > root.val:
            res = root.left.val - root.val <= 1
        else:
            res = root.val - root.left.val <= 1

        root.val = max(root.val, root.left.val) + 1
    else:
        if root.left.val > root.right.val:
            res = root.left.val - root.right.val <= 1
        else:
            res = root.right.val - root.left.val <= 1
        root.val = max(root.left.val, root.right.val) + 1

    return left and right and res


def isLeaf(root: Optional[TreeNode]) -> bool:
    return not root.left and not root.right
