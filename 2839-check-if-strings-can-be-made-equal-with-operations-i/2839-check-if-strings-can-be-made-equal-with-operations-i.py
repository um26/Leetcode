class Solution:
    def canBeEqual(self, s1: str, s2: str) -> bool:
        s3 = s1[2] + s1[1] + s1[0] + s1[3]
        s4 = s1[0] + s1[3] + s1[2] + s1[1]
        s5 = s1[2] + s1[3] + s1[0] + s1[1]
        if s1 == s2 or s2 == s3 or s2 == s4 or s2 == s5: return True
        return False