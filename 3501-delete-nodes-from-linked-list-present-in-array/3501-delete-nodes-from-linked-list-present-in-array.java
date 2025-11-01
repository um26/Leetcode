import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> toDelete = new HashSet<>();
        for (int num : nums) {
            toDelete.add(num);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            if (toDelete.contains(curr.val)) {
                prev.next = curr.next; // skip current node
            } else {
                prev = curr; // move prev forward
            }
            curr = curr.next; // move curr forward
        }

        return dummy.next;
    }
}