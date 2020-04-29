import org.junit.Test;

/**
 * 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 2020/04/29
 */
public class LeetCodeInterview06 {
    @Test
    public void name() {

    }

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[]{};
        int size = 1;
        ListNode curr = head;

        // 找到队尾
        while (curr.next != null) {
            curr = curr.next;
            size++;
        }

        curr = head;
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = curr.val;
            curr = curr.next;
        }

        return ans;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
