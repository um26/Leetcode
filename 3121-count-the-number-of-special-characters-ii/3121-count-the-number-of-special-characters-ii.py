class Solution:
    def numberOfSpecialChars(self, word: str) -> int:

        lower_char_set = set()
        upper_char_set = set()

        special_set = set()
        failed_set = set()


        for ch in word:
            if ch.islower():
                lower_char_set.add(ch)
                
                if ch.upper() in upper_char_set:
                    failed_set.add(ch)
                    if ch in special_set:
                        special_set.remove(ch)
                    
            else: # ch.isupper()
                upper_char_set.add(ch)

                if ch.lower() in lower_char_set and ch.lower() not in failed_set:
                    special_set.add(ch.lower())
                    
        return len(special_set)



        