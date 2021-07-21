package hss.basic.hot100;


import java.util.List;

/**
 * @author HSS
 * @Date: 2021/7/7 14:57
 * @Description: 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode tmp1 = new ListNode(3, null);
        ListNode tmp2 = new ListNode(4, tmp1);
        ListNode l1 = new ListNode(2, tmp2);
        ListNode tmp3 = new ListNode(4, null);
        ListNode tmp4 = new ListNode(6, tmp3);
        ListNode l2 = new ListNode(5, tmp4);
        System.out.println(l1);
        System.out.println(l2);

        ListNode res = addTwoNumbers(l1, l2);

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        int K = 0;
        if (length(l1) < length(l2)) {
            ListNode nodeTmp = l1;
            l1 = l2;
            l2 = nodeTmp;
        }
        do {
            if (l2.next == null) {
                l2.next = new ListNode(0, null);
            }
            int target = (l1.val + l2.val + K) % 10;
            K = (l1.val + l2.val + K) / 10;
            ListNode tmp = new ListNode(target, null);
            res = addNode(res, tmp);


            l1 = l1.next;
            l2 = l2.next;
        } while (l1 != null);
        if (K > 0) {
            res = addNode(res, new ListNode(K, null));
        }

        return res;
    }

    private static ListNode addNode(ListNode res, ListNode target) {
        if (res == null) {
            res = target;
            return res;
        }
        ListNode tmp = res;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = target;

        return res;
    }

    private static int length(ListNode target) {
        int res = 0;
        if (target != null) {
            res++;
        }
        while (target.next != null) {
            res++;
            target = target.next;
        }
        return res;
    }

}

class ListNode {
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
