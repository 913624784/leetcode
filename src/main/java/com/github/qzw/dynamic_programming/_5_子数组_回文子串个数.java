package com.github.qzw.dynamic_programming;

import java.util.Arrays;

/**
 * @Author: qizhiwei
 * @date: 2022/2/14
 * @PackageName: com.github.qzw.dynamic_programming
 * @Description: 问题：给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 示例1：
 * <p>
 * 输入："dp"
 * 输出：2
 * 解释：共有两个回文子串，分别为 "d", "p"。
 * 示例2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：共有六个回文子串，分别为 "a", "a", "a", "aa", "aa", "aaa"。注意题设，具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串，
 * 因此像 "aa" 和 "aa" 就是两个不同的回文子串。
 */
public class _5_子数组_回文子串个数 {

    /**
     * DP[i][j] 所对应的值是子串 i…j 是否为回文（True 或 False）
     * i是子串开始位置 j是子串结束位置
     * 时间复杂度为O(N^2)
     * 空间复杂度为O(N^2)
     *
     * @param s 输入字符串
     * @return 回文串数量
     */
    static int countSubstrings(String s) {
        int n = s.length();
        if (0 == n) {
            return 0;
        }

        // 计数器，如果是回文串就加1
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        /**
         * 单个字符一定为回文，所以为True
         */
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }

        /**
         * 当子问题局限于单字符时，它一定是回文（如 “a”），因此子问题的答案是 True
         * 当子问题是由相同的两个字符构成的，它一定是回文（如 “aa”），因此子问题的答案是 True
         * 当子问题是由左右两个相同字符外加一个任意字符，共三个字符构成时，它一定是回文（如 “aba”），因此子问题的答案是 True
         */
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        for (boolean[] x : dp) {
            System.out.println(Arrays.toString(x));
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
}
