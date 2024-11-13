# Time Complexity: O(log n) || Space Complexity: O(n)
from Trees.Treenode import TreeNode


def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
    if not root or not q or not p:
        return None

    if root.val < p.val and root.val < q.val:
        return lowestCommonAncestor(root.right, p, q)
    elif root.val > p.val and root.val > q.val:
        return lowestCommonAncestor(root.left, p, q)
    else:
        return root
