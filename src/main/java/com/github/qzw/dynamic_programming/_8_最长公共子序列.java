package com.github.qzw.dynamic_programming;

import java.util.Arrays;

/**
 * @Author: qizhiwei
 * @date: 2022/2/17
 * @PackageName: com.github.qzw.dynamic_programming
 * @Description: 问题：给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。若这两个字符串没有公共子序列，则返回 0。其中：
 * <p>
 * 1 ≤ text1.length ≤ 1000；
 * 1 ≤ text2.length ≤ 1000；
 * 输入的字符串只含有小写英文字符。
 * 示例1：
 * <p>
 * 输入：text1 = "abcde", text2 = "ade"
 * 输出：3
 * 解释：最长公共子序列是 "ade"，它的长度为 3。
 * 示例2:
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：显然，两个字符串没有公共子序列，返回 0。
 */
public class _8_最长公共子序列 {

    /**
     * DP[i][j] 表示的是 text1[0 … i] 和 text2[0 … j] 的最长公共子序列的长度
     */
    static int getLongestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (text2.charAt(j - 1) == text1.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int[] x : dp) {
            System.out.println(Arrays.toString(Arrays.stream(x).toArray()));
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ade";
        System.out.println(getLongestCommonSubsequence(text1, text2));
    }
}
