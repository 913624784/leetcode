package com.github.qzw.dynamic_programming;

import java.util.Arrays;

/**
 * @Author: qizhiwei
 * @date: 2022/3/7
 * @PackageName: com.github.qzw.dynamic_programming
 * @Description: 问题：一个机器人位于一个 m * n 网格的左上角 （起始点在下图中标记为“开始” ），机器人每次只能向下或者向右移动一步，
 * 现在机器人试图达到网格的右下角（在下图中标记为“结束”）。问总共有多少条不同的路径？
 * 示例：
 * <p>
 * 输入：m = 3, n = 2
 * 输出： 3
 * 解释: 从左上角开始，总共有 3 条路径可以到达右下角：
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 */
public class _9_简单路径规划 {
    static int getPathCount(int m, int n) {
        //表示第 i 行、第 j 列的路径数量
        int[][] dp = new int[m][n];

        // 初始化状态
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) { // 状态转移过程
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        for (int[] x : dp) {
            System.out.println(Arrays.toString(Arrays.stream(x).toArray()));
        }
        return dp[m - 1][n - 1]; // 输出答案
    }

    public static void main(String[] args) {
        System.out.println(getPathCount(3, 2));
    }
}
