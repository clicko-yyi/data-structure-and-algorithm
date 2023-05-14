package offer.queue;

import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;

/*
[面试题59 - II. 队列的最大值](https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/)

 */
public class O59n2 {
    public static void main(String[] args) {

    }
}
class MaxQueue {
    Queue<Integer> q;
    Deque<Integer> d;

    public MaxQueue() {
        q = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}

class MaxQueue2 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;
    ListNode back;
    ListNode max;

    public MaxQueue2() {

    }

    public int max_value() {
        return max == null ? -1 : max.val;
    }

    public void push_back(int value) {
        if (back == null) {
            back = new ListNode(value);
            head = back;
            max = back;
            return;
        }
        back.next = new ListNode(value);
        back = back.next;
        if (max != null && back.val > max.val) {
            max = back;
        }
    }

    public int pop_front() {
        if (head == null) return -1;
        ListNode res = head;
        head = head.next;
        if (res == back) { // 最后一个节点
            back = null;
        }
        if (res == max) { // 头节点刚好是最大值
            // 更新最大值
            ListNode p = head;
            max = p;
            while (p != null) {
                if (p.val > max.val)
                    max = p;
                p = p.next;
            }
        }
        return res.val;
    }
}