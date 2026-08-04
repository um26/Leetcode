class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        mn = min(nums)
        mx = max(nums)

        if len(nums) == mx - mn + 1:
            return []

        nums = set(nums)
        res = []

        for i in range(mn, mx + 1):
            if i not in nums:
                res.append(i)

        return res