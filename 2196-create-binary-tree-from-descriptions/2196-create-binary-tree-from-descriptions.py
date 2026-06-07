class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:

        nodes    = {}        # value → TreeNode
        children = set()     # all values that have a parent

        for parent, child, is_left in descriptions:

            if parent not in nodes:
                nodes[parent] = TreeNode(parent)   # Create parent node if unseen
            if child not in nodes:
                nodes[child]  = TreeNode(child)    # Create child node if unseen

            children.add(child)                    # Track every child

            if is_left == 1:
                nodes[parent].left  = nodes[child]
            else:
                nodes[parent].right = nodes[child]

        for parent, _, _ in descriptions:
            if parent not in children:             # Root is never someone's child
                return nodes[parent]