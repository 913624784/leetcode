package com.github.qzw;

import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author : qizhiwei
 * @date : 2021/4/22
 * @Description :
 */
public class Main {

    //         a
    //   b          c
    // d   e

    public static int reserver(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int num_l = 0;
        int num_r = 0;
        if (root.left != null) {
            num_l = reserver(root.left) + 1;
        }
        if (root.right != null) {
            num_r = reserver(root.right) + 1;
        }
        System.out.println("(" + root.val + "   " + (num_l + num_r) + ")");
        return num_l + num_r;
    }

    public static int solution(String str) {
        char[] nums = str.toCharArray();
        int result = 0;
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] == '1') {
                result += 2;
            } else {
                result += 1;
            }
        }
        if (nums[i] == '1') {
            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 400000; i++) {
            sb.append("1");
        }
        System.out.println(solution(sb.toString()));
        System.out.println(solution("1010"));
        System.out.println(solution("1111"));


        TreeNode root = new TreeNode("a");
        root.left = new TreeNode("b");
        root.right = new TreeNode("c");
        root.left.left = new TreeNode("d");
        root.left.right = new TreeNode("e");
        reserver(root);

        HashMap map = new HashMap();
        map.put("a", "0");
        map.put("b", "a+c");
        map.put("c", "4");
        Serializable com = MVEL.compileExpression("a+c");

        System.out.println(MVEL.executeExpression(com, map));

    }
}
