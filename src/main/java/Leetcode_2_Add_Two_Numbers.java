package src.main.java;

public class Leetcode_2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = l2;

        boolean increment = false;
        boolean newIncrement;

        while (l1 != null && l2 != null) {
            newIncrement = increment ? (l1.val + l2.val + 1) / 10 == 1 : (l1.val + l2.val) / 10 == 1;
            l2.val = increment ? (l1.val + l2.val + 1) % 10 : (l1.val + l2.val) % 10;
            increment = newIncrement;

            if (l1.next != null && l2.next == null) {
                l2.next = l1.next;
                l1 = l1.next;
                l2 = l2.next;
                break;
            } else if (l1.next == null && l2.next == null && increment) {
                l2.next = new ListNode(1);
                increment = false;
                break;
            }

            l1 = l1.next;
            l2 = l2.next;

            System.out.println(increment);
        }

        while (l2 != null && increment) {
            increment = (l2.val + 1) / 10 == 1;
            l2.val = (l2.val + 1) % 10;
            if (l2.next == null && increment) {
                System.out.println("3: " + increment);
                l2.next = new ListNode(1);
                break;
            } else
                l2 = l2.next;
        }

        return resultNode;
    }

    public ListNode addTwoNumbersOptimum(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}