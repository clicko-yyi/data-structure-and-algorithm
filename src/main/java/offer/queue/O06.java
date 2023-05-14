package offer.queue;


import java.util.ArrayList;
import java.util.List;

/*
[剑指 Offer 06. 从尾到头打印链表](https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)
示例 1：

输入：head = [1,3,2]
输出：[2,3,1]

 */
public class O06 {
    public static void main(String[] args) {

    }

    public int[] reversePrint_solution_1(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; --i) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }

    List<Integer>list =new ArrayList<>();
    void traverse(ListNode head)
    {
        if(head==null)
        {
            return;
        }
        traverse(head.next);
        list.add(head.val);

    }
    public int[] reversePrint_solution_2(ListNode head) {
        traverse(head);
        int[]res=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            res[i]=list.get(i);
        }
        return res;
    }

    public int[] reversePrint_solution_3(ListNode head) {
        List<Integer> resList = reverse(head);
        return resList.stream().mapToInt(Integer::valueOf).toArray();
    }

    private List<Integer> reverse(ListNode head) {
        if (null == head) {
            return new ArrayList<>();
        }
        List<Integer> res = reverse(head.next);
        res.add(head.val);
        return res;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}