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