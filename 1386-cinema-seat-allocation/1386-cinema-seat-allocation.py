class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        dd = {}
        for r, s in reservedSeats:
            if s == 1 or s == 10:
                    continue
            elif r not in dd:
                dd[r] = ['0'] * 8
            val = dd[r]
            val[s - 2] = '1'
        ans = 2 * (n - len(dd))
        def process(row):
            acc = 0
            f = False
            if row[0] == '0' and row[1] == '0' and row[2] == '0' and row[3] == '0':
                acc += 1
                f = True
            if row[4] == '0' and row[5] == '0' and row[6] == '0' and row[7] == '0':
                acc += 1
                f = True
            if not f:
                if row[2] == '0' and row[3] == '0' and row[4] == '0' and row[5] == '0':
                    acc += 1
            return acc
        for row in dd:
            ans += process(dd[row])
        return ans