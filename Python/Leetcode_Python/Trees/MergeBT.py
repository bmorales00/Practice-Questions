# Time Complexity: O(n) || Space Complexity: O(1) unless you count stack -> O(n)
 
from typing import Optional
from Treenode import TreeNode


def mergeTrees(
    root1: Optional[TreeNode], root2: Optional[TreeNode]
) -> Optional[TreeNode]:

    if not root1 and root2:
        return root2

    if not root2 and root1:
        return root1

    if root1 and root2:
        root1.val = root1.val + root2.val
        root1.left = mergeTrees(root1.left, root2.left)
        root1.right = mergeTrees(root1.right, root2.right)

    return root1
