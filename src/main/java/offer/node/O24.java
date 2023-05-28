package offer.node;

import java.util.LinkedList;

/*
[剑指 Offer 24. 反转链表](https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/)
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */
public class O24 {
    public static void main(String[] args) {
        int[] array = new int[] {5, 1, 9};
        ListNode current = new ListNode(4);
        ListNode head = current;
        for (int x : array) {
            current.next = new ListNode(x);
            current = current.next;
        }
        O24 o24 = new O24();
        ListNode newHead = o24.reverseList_solution_1(head);

        current = newHead;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public ListNode reverseList_solution_1(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        stack.push(null);

        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        ListNode cur = stack.pop();
        ListNode newHead = cur;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }

        return newHead;
    }

    public ListNode reverseList_solution_2(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
}