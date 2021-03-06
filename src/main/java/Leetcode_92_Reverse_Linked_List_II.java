import src.main.java.Leetcode_21_Merge_Two_Sorted_Lists.ListNode;

public class Leetcode_92_Reverse_Linked_List_II {
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n) {
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.val = 0;
            dummy.next = head;
            int count = 0;
            ListNode left1 = null;
            ListNode left2 = null;
            ListNode pre = dummy;
            while (head != null) {
                count++;
                //到达 m，保存 l1 和 l2
                if (count == m) {
                    left1 = pre;
                    left2 = head;
                }
                // m 和 n 之间，倒转链表
                if (count > m && count < n) {
                    ListNode temp = head.next;
                    head.next = pre;
                    pre = head;
                    head = temp;
                    continue;
                }
                //到达 n
                if (count == n) {
                    left2.next = head.next;
                    head.next = pre;
                    left1.next = head;
                    break;
                }
                //两个指针后移
                head = head.next;
                pre = pre.next;
            }
            return dummy.next;
        }
    }
}
