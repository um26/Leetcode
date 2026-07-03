class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        hash1 = {}
        hash2= {}

        if (len(s)!=len(t)):
            return False

        for char in s:
            if char in hash1:
                hash1[char]+=1
            else:
                hash1[char]=1
        
        for char in t:
            if char in hash2:
                hash2[char]+=1
            else:
                hash2[char]=1

        return hash1==hash2