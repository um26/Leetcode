class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        num_rows, num_cols = len(box), len(box[0])
        rotated_box = [['.'] * num_rows for _ in range(num_cols)]
        
        for row_index, row in enumerate(box):
            last_position = num_cols - 1
            for col_index in range(num_cols - 1, -1, -1):
                if row[col_index] == '#':
                    rotated_box[last_position][num_rows - 1 - row_index] = '#'
                    last_position -= 1
                elif row[col_index] == '*':
                    rotated_box[col_index][num_rows - 1 - row_index] = '*'
                    last_position = col_index - 1
        
        return rotated_box