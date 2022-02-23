package com.github.qzw.dynamic_programming;

import java.util.Arrays;

/**
 * @Author: qizhiwei
 * @date: 2022/2/16
 * @PackageName: com.github.qzw.dynamic_programming
 * @Description: 问题：给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000。
 * <p>
 * 示例1：
 * <p>
 * 输入："asssasms"
 * 输出：5
 * 解释：一个可能的最长回文子序列为 "sssss"，另一种可能的答案是 "asssa"。
 * 示例2：
 * <p>
 * 输入："abba"
 * 输出：4
 * 解释：有三个子序列满足题设要求："aa"、"bb" 和 "abba"，因此答案为 4。
 */
public class _7_最长回文子序列 {

    /**
     * 设DP[i][j]，其对应的值是字符串 i…j 中最长回文子序列的长度
     */
    static int getLongestPalindromeSubseq(String s) {
        int n = s.length();
        if (0 == n) {
            return 0;
        }

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1; // 初始化状态
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // 作出进一步决策
                }
            }
        }
        for (int[] x : dp) {
            System.out.println(Arrays.toString(Arrays.stream(x).toArray()));
        }
        return dp[0][n - 1]; // 输出答案
    }

    public static void main(String[] args) {
        String s = "asssasms";
        System.out.println(getLongestPalindromeSubseq(s));
    }
}
