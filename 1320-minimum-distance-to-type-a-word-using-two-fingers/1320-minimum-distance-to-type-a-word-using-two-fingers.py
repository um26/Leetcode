from functools import lru_cache
class Solution:
    def minimumDistance(self, word: str) -> int:
        @lru_cache(None)
        def helper(word, i, pos1, pos2):
            if i==len(word):
                return 0
            ch = ord(word[i]) - ord('A')
            dist1 = dist(ch, pos1) + helper(word, i+1, ch, pos2)
            dist2 = dist(ch, pos2) + helper(word, i+1, pos1, ch)
            return min(dist1, dist2)
        def dist(ch, pos):
            if pos == -1: return 0
            x1 = ch//6
            y1 = ch%6
            x2 = pos//6
            y2 = pos%6
            return abs(x2-x1) + abs(y2-y1)
        return helper(word, 0, -1, -1)
        