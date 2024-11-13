# Time Complexity: O(n) || Space Complexity: O(1)
from Trees import TreeNode


def invertTree(root: Optional[TreeNode]) -> Optional[TreeNode]:
    if root is None:
        return None
    left = invertTree(root.left)
    right = invertTree(root.right)

    root.left = right
    root.right = left

    return root
