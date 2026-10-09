class Solution:
    def minInsertions(self, s: str) -> int:
        ans = 0
        s = s.replace("))", "]")
        ans += s.count(")")
        s = s.replace(")", "]")
        while "(]" in s:
            s = s.replace("(]", "")
        # s will now be in the form of "]]...]((...("
        ans += s.count("]")
        ans += s.count("(") * 2
        return ans