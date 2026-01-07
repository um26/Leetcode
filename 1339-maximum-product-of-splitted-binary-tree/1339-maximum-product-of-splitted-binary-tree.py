# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        def prefix(node):
            # add children nodes to the parent nodes to create a prefix sum tree
            if not node: return 0
            left = prefix(node.left)
            right = prefix(node.right)
            node.val += left + right
            return node.val
        prefix(root)
        ans = [0]
        def dfs(node, total):
            # check by elimination of left and right edges for max sum
            if node.left:
                ans[0]= max(ans[0], (total - node.left.val) * node.left.val)
                dfs(node.left, total)
            if node.right:
                ans[0] = max(ans[0], (total - node.right.val) * node.right.val)
                dfs(node.right, total)
        dfs(root, root.val)
        return ans[0] % 1000_000_007