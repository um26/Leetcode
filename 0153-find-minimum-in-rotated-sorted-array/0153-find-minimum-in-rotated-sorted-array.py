class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums[0] > nums[-1]:
            index = self.CustomBinarySearch(nums)
            return nums[index]
        return nums[0]
    
    def CustomBinarySearch(self, nums):
        s,e = 0, len(nums)-1
        while s < e:
            m = s + (e-s)//2
            if nums[m] < nums[e]:
                e-=1
            else:
                s+=1
        return e