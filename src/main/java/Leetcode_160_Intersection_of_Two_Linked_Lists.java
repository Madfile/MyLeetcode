package src.main.java;

public class Leetcode_160_Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthOfA = getListLength(headA);
        int lengthOfB = getListLength(headB);

        ListNode shortNode;
        ListNode longNode;
        if (lengthOfA > lengthOfB) {
            shortNode = headB;
            longNode = headA;
        } else {
            shortNode = headA;
            longNode = headB;
        }

        int sum = Math.abs(lengthOfA - lengthOfB);

        for (int i = 0; i < sum; i++) {
            longNode = longNode.next;
        }

        while(shortNode != null) {
            if (shortNode == longNode) {
                return shortNode;
            } else {
                shortNode = shortNode.next;
                longNode = longNode.next;
            }
        }

        return null;
    }

    private int getListLength(ListNode head) {
        int length = 0;
        while(head.next != null) {
            length++;
            head = head.next;
        }

        return length;
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
