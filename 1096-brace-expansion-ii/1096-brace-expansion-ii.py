class Solution:
    def braceExpansionII(self, expression: str) -> list[str]:
        s = expression
        n = len(s)
        pos = 0  # single shared pointer via list/nonlocal

        def parseUnion() -> set:
            nonlocal pos
            result = parseConcat()
            while pos < n and s[pos] == ',':
                pos += 1
                result |= parseConcat()
            return result

        def parseConcat() -> set:
            nonlocal pos
            result = {""}
            while pos < n and s[pos] not in ',}':
                term = parseTerm()
                result = {a + b for a in result for b in term}
            return result

        def parseTerm() -> set:
            nonlocal pos
            if s[pos] == '{':
                pos += 1          # skip '{'
                result = parseUnion()
                pos += 1          # skip '}'
                return result
            else:
                letter = s[pos]
                pos += 1
                return {letter}

        return sorted(parseUnion())
        