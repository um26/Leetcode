class Solution:
    def isPalindrome(self, s: str) -> bool:
        new = ''.join(c.lower() for c in s if c.isalnum())
        L=0
        R=len(new)-1

        while L<R:
            if new[L]!= new[R]:
                return False
            L+=1
            R-=1
        return True