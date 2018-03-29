package solution2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur_node = res;
        //进位
        boolean plus1 = false;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (plus1 ? 1 : 0);
            if (sum < 10) {
                plus1 = false;
                cur_node.next = new ListNode(sum);
            } else {
                plus1 = true;
                cur_node.next = new ListNode(sum - 10);
            }
            cur_node = cur_node.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (plus1) {
            cur_node.next = new ListNode(1);
        }

        return res.next;
    }

}
