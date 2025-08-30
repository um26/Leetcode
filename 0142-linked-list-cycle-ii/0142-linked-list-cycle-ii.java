
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode ptr=head;
        int flag=0;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                flag=1;
                break;
            } 
        }
        if(flag==0) return null;
        while(ptr!=slow){
                ptr=ptr.next;
                slow=slow.next;
            }
        return ptr;
    }
}