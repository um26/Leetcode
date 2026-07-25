class Solution:
    def maxProduct(self, n: int) -> int:
        n1=n%10
        n//=10
        n2=n%10
        n//=10
        while n>0:
            if((n%10>=n1) and (n%10>=n2)):
                n1=max(n1,n2)
                n2=n%10
            elif(n%10>n1):
                n1=n%10
            elif(n%10>n2):
                n2=n%10
            n//=10
        return n1*n2