package com.github.qzw;

/**
 * @author : qizhiwei
 * @date : 2021/4/16
 * @Description : Defined TreeNode
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public String val;

    public TreeNode(int val) {
        this.val = String.valueOf(val);
    }
    TreeNode(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", val=" + val +
                '}';
    }
}
