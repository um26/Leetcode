class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        L=0
        R=1
        n=len(nums)

        while (R<n and L<n):
            if(nums[L]!=0):
                L+=1
                R=L
            elif(nums[R]==0):
                R+=1
            else:
                temp=nums[L]
                nums[L]=nums[R]
                nums[R]=temp
        