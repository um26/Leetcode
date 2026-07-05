class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        mod = 10**9 + 7
        n = len(board)
        
        @cache
        def dfs(i: int, j: int) -> Tuple[int, int]:
            #base
            if i < 0 or j < 0 or board[i][j] == 'X':
                return [-1, 0]
            
            if i == 0 and j == 0:
                return [0, 1]
            
            candidates = []
            #up, left, dig up-left
            for ni, nj in [(i - 1, j), (i, j - 1), (i - 1, j - 1)]:
                score, ways = dfs(ni, nj)
                if score >= 0:
                    candidates.append((score, ways))

            if not candidates:
                return (-1, 0)
            
            max_score = max(s for s, _ in candidates)
            total_ways = sum(w for s, w in candidates if s == max_score) % mod

            val = 0
            if board[i][j].isdigit():
                val = int(board[i][j])

            return (max_score + val, total_ways)
        
        score, ways = dfs(n - 1, n - 1)
        if score < 0:
            return [0, 0]
        return [score, ways]
