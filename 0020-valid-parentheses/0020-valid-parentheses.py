class Solution:
    def isValid(self, s: str) -> bool:
        a=[]
        n=len(s)
        if (n==0):
            return True
        if (n==1):
            return False

        for char in s:
            if((len(a)==0) and ((char=='}') or (char==']') or (char==')'))):
                return False
            if ((char=='(') or (char=='{') or (char=='[')):
                a.append(char)
            if (char==')'):
                x=a.pop()
                if (x!='('):
                    return False
            if (char=='}'):
                x=a.pop()
                if (x!='{'):
                    return False
            if (char==']'):
                x=a.pop()
                if (x!='['):
                    return False
        return len(a)==0