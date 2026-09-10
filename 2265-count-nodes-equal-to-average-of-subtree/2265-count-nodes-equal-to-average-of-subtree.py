
class Solution:
    def averageOfSubtree(self, root: TreeNode) -> int:
        def dfs(root):
            nonlocal ans
            if not root: return (0, 0)

            l = dfs(root.left)
            r = dfs(root.right)

            if root.val == (root.val + l[0] + r[0]) // (1 + l[1] + r[1]):
                ans += 1

            return (root.val + l[0] + r[0], 1 + l[1] + r[1])

        ans = 0
        dfs(root)

        return ans