# Time Complexity: O(n) || Space Complexity: O(n)
from typing import Optional
from Treenode import TreeNode


def isSameTree(p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
    if not p and not q:
        return True
    elif (p and not q) or (q and not p):
        return False
    elif p.val != q.val:
        return False
    else:
        isSameTree(p.left, q.left) and isSameTree(p.right, q.right)
