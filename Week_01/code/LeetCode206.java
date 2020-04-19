import org.junit.Test;

import java.util.LinkedList;

public class LeetCode206 {
    @Test
    public void name() {
        int[] array = new int[]{2, 3, 4, 5};
        ListNode head = null, curr = null;
        for (int i : array) {
            ListNode node = new ListNode(i);
            if (head != null) {
                head = node;
            }

//            curr =
            "121".charAt(0);
            LinkedList<Character> list = new LinkedList<>();
            list.isEmpty();
        }
        reverseList(head);
        System.out.println();
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }

        head = stack.pop();
        for (ListNode curr : stack) {
            head.next = curr;
            head = curr;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
