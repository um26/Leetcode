class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap = {}
        n= len(nums)

        for i in range(n):
            c= target - nums[i]
            if c in hashMap:
                return [hashMap[c],i]
            hashMap[nums[i]]=i
        return []