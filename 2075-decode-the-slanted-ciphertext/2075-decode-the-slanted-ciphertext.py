class Solution:
    def decodeCiphertext(self, encodedtext: str, no_of_rows: int) -> str:
        length_of_encodedtext = len(encodedtext)
        no_of_cols = length_of_encodedtext//no_of_rows
        res = ""
        matrix = [[' ' for _ in range(no_of_cols)]for _ in range(no_of_rows)]
        k = 0
        for i in range(no_of_rows):
            for j in range(no_of_cols):
                matrix[i][j] = encodedtext[k]
                k = k + 1

        curr_row =  curr_col = 0
        pointer_row = 0
        pointer_col = 0

        while curr_row < no_of_rows and curr_col < no_of_cols:
            res  = res + matrix[curr_row][curr_col]
            curr_row += 1 
            curr_col += 1 
            if curr_row == no_of_rows:
                curr_col = pointer_col + 1 
                curr_row = 0
                pointer_col = curr_col
            if curr_col == no_of_cols:
                curr_row = 0
                curr_col = pointer_col + 1     
                pointer_col = curr_col
        return res.rstrip()