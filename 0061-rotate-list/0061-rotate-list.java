/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return head;
        if (head.next==null) return head;
        
        ListNode a= head;
        ListNode b= head;
        int count=0;
        ListNode current= head;
        while(current!=null){
            current=current.next;
            count++;
        }

        k%=count;
        if (k==0) return head;

        for(int i=1;i<k;i++){
            b=b.next;
        }
        ListNode prev= new ListNode();
        while(b.next!=null){
            //current.next=a;
            prev=a;
            a=a.next;
            b=b.next;
        }
        b.next=head;
        head=a;
        prev.next=null;
        return head;
    }
}