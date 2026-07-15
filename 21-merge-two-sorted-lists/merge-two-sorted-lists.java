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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node banate hain taaki head handle karna easy ho
        ListNode dummy = new ListNode(-1);

        // Ye merged list ke last node ko point karega
        ListNode current = dummy;

        // Jab tak dono lists me nodes hain
        while (list1 != null && list2 != null) {

            // Chhoti value wali node ko merged list me jod do
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            // Current ko aage badhao
            current = current.next;
        }

        // Agar list1 me nodes bache hain to jod do
        if (list1 != null) {
            current.next = list1;
        }

        // Agar list2 me nodes bache hain to jod do
        if (list2 != null) {
            current.next = list2;
        }

        // Dummy ke baad wala node hi merged list ka head hai
        return dummy.next;
    }
}