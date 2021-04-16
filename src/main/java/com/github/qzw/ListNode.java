package com.github.qzw;

/**
 * @author : qizhiwei
 * @date : 2021/4/16
 * @Description : Defined ListNode
 */
public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}
