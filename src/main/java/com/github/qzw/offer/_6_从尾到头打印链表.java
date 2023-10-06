package com.github.qzw.offer;

import com.github.qzw.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author : qizhiwei
 * @date : 2021/4/16
 * @Description : https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class _6_从尾到头打印链表 {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        //遍历链表装到栈中
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        //遍历栈 输出到数组中
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        System.out.println(Arrays.toString(reversePrint(node)));
    }
}
