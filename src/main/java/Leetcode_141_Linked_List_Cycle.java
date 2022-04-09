package src.main.java;

public class Leetcode_141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            if (slow == fast.next || slow == fast.next.next) {
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }

        return false;
    }
    
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
