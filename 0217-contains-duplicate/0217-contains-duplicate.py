class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        hashMap = {}
        n = len(nums)

        for i in range(n):
            if nums[i] in hashMap:
                return True
            hashMap[nums[i]]=i
        return False