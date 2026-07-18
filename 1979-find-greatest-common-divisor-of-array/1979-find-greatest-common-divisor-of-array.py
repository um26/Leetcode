class Solution:
    def findGCD(self, nums: List[int]) -> int:
        l=nums[0]
        h=nums[0]
        for i in range(len(nums)):
            if nums[i]<l:
                l=nums[i]
            if nums[i]>h:
                h=nums[i]
        x=l
        while x>1:
            if h%x==0 and l%x==0:
                return x
            x-=1
        return 1