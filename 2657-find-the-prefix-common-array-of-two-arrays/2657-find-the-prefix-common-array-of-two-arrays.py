class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        return (s0:=set()) or (s1:=set()) or list(
            accumulate(zip(A,B),
                lambda s,e: s + (s0.add(e[0]) or s1.add(e[1]) or 0) +(e[0] in s1) +(e[1] in s0) -(e[0]==e[1]),
                initial = 0
            )
        )[1:]
        