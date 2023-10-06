package com.github.qzw.offer;

/**
 * @author : qizhiwei
 * @date : 2021/4/16
 * @Description : https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class _5_替换空格 {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "s = We are happy.";
        System.out.println(replaceSpace(s));
    }
}
