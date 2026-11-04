class Solution:
    def minMoves(self, nums: List[int]) -> int:
        maximumElement = max(nums)
        moves = 0
        for i in nums:
            moves += maximumElement - i
        return moves