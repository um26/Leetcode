class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n=len(nums)
        L=1
        R=0

        while R<n-1:
            if(nums[R]==nums[R+1]):
                R+=1
            else:
                nums[L]=nums[R+1]
                L+=1
                R+=1
        return L