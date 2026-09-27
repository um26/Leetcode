class Solution:
    def reverseParentheses(self, s: str) -> str:
        while "(" in s:
            start=s.rfind("(")
            end=s.find(")", start)
            rev= s[start+1:end][::-1]
            s=s[:start]+rev+s[end+1:]
        return s