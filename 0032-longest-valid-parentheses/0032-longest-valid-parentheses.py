class Solution:
    def longestValidParentheses(self, s: str) -> int:
        left = 0
        right = 0
        maxi = 0

        # Left to right
        for ch in s:
            if ch == '(':
                left += 1
            else:
                right += 1

            if left == right:
                maxi = max(maxi, 2 * right)
            elif right > left:
                left = right = 0

        # Right to left
        left = 0
        right = 0

        for ch in reversed(s):
            if ch == '(':
                left += 1
            else:
                right += 1

            if left == right:
                maxi = max(maxi, 2 * left)
            elif left > right:
                left = right = 0

        return maxi