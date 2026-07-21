class Solution:
    def maxActiveSectionsAfterTrade(self, s: str) -> int:
        return  s.count('1') + max((
            m0.end()-m0.start() + m1.end()-m1.start() 
            for m0,m1 in pairwise(re.finditer(r'0+',s))
        ),  default=0)