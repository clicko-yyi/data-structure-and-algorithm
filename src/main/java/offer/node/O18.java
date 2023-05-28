package offer.node;

/*
[剑指 Offer 18. 删除链表的节点](https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/)
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 ->
 */
public class O18 {
    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 9};
        ListNode current = new ListNode(4);
        ListNode head = current;
        for (int x : array) {
            current.next = new ListNode(x);
            current = current.next;
        }
        O18 o18 = new O18();
        ListNode newHead = o18.deleteNode_solution_1(head, 4);

        current = newHead;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public ListNode deleteNode_solution_1(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode current = head;
        ListNode pre = dummy;

        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
            }
            pre = pre.next;
            current = current.next;
        }
        return dummy.next;
    }

    public ListNode deleteNode_solution_2(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteNode_solution_3(ListNode head, int val) {
        if (head == null)
            return head;
        if (head.val == val)
            return head.next;
        head.next = deleteNode_solution_3(head.next, val);
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}