package com.github.qzw.leetcode_top100.mid;

import com.github.qzw.ListNode;

/**
 * @author : qizhiwei
 * @date : 2021/4/26
 * @Description : https://leetcode-cn.com/problems/add-two-numbers/
 */
public class _2_两数相加 {
    /**
     * 时间复杂度 O(max(m,n))
     * 空间复杂度 O(1)
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        //进位余数 初始 0
        int carry = 0, i = 0;
        while (p != null || q != null) {
            //假定俩链表一样长 如果不一样长 补 0
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            //如果加和大于 10 正常返回，否则为 0 代表小于 10
            int sum = carry + x + y;
            System.out.println(i + " -> x:" + x + " y:" + y + " sum:" + sum);
            // 进位值
            carry = sum / 10;
            //curr 为头结点为 0 的初始链表
            //input
            //[2,4,3,6]
            //[5,6,4]
            //output
            //[7,0,8,6]
            System.out.println(i + " -> curr:" + curr);
            curr.next = new ListNode(sum % 10);
            System.out.println(i + " -> curr:" + curr);
            curr = curr.next;
            System.out.println(i + " -> curr:" + curr);
            System.out.println(i + " -> dummyHead:" + dummyHead);
            System.out.println();
            i++;
            //继续遍历链表
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        //说明加和大于 10 需要进位 增加一个为 carry 的节点
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(6);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));

    }
}
