class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        a1=sorted(nums1)
        a2=sorted(nums2)
        o=[]
        i=0
        j=0

        while i<len(a1) and j<len(a2):
            if a1[i]<a2[j]:
                i+=1
            elif a1[i]>a2[j]:
                j+=1
            else:
                o.append(a1[i])
                i+=1
                j+=1
        return o