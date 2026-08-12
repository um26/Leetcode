class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        #find the longest subarray where the frequencuy of all element is less than equal to k 
        n=len(nums)  #helo
        mp=defaultdict(int)    #denget
        l=0 
        ans=0
        for r in range(n):
            mp[nums[r]]+=1
            while l<=r and mp[nums[r]]>k:
                l+=1
                mp[nums[l-1]]-=1
            ans=max(ans,r-l+1)
        return ans