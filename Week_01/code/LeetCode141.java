import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LeetCode141 {
    @Test
    public void name() {
        ListNode listNode = new ListNode(1);
        System.out.println(hasCycle(listNode));
    }

    Set<ListNode> set = new HashSet<>();

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        while (head != null) {
            if (set.add(head)) {
                head = head.next;
            } else return true;
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
