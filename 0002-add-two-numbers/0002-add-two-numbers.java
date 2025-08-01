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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1, temp2=l2;
        ListNode x=new ListNode();
        ListNode temp=x;
        int sum=0,carry=0,a=0,b=0;
        while(temp1!=null || temp2!=null || carry!=0){
            if(temp1==null){
                a=0;
            }else{
                a=temp1.val;
            }
            if(temp2==null){
                b=0;
            }else{
                b=temp2.val;
            }
            sum=(carry+a+b)%10;
            carry=(carry+a+b)/10;
            temp.next=new ListNode(sum);
            temp=temp.next;
            if (temp1 != null) {
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }
        return x.next;
    }
}