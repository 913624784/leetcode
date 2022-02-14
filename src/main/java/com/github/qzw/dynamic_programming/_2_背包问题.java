package com.github.qzw.dynamic_programming;

import java.util.Arrays;

/**
 * @Author: qizhiwei
 * @date: 2022/2/9
 * @PackageName: com.github.qzw.dynamic_programming
 * @Description: 0-1背包
 * 问题：给你一个可放总重量为 W 的背包和 N 个物品，对每个物品，有重量 w 和价值 v 两个属性，那么第 i 个物品的重量为 w[i]，价值为 v[i]。现在让你用这个背包装物品
 * 问最多能装的价值是多少？
 * <p>
 * 示例：
 * <p>
 * 输入：W = 5, N = 3
 * w = [3, 2, 1], v = [5, 2, 3]
 * 输出：8
 * 解释：选择 i=0 和 i=2 这两件物品装进背包。它们的总重量 4 小于 W，同时可以获得最大价值 8
 */
public class _2_背包问题 {

    /**
     * @param w 物品的重量
     * @param v 物品的价值
     * @param N 物品的总数
     * @param W 背包能容纳的总重量
     * @return 最大价值
     */
    static int dp(int[] w, int[] v, int N, int W) {
        // 创建备忘录，初始化状态
        int[][] dp = new int[N + 1][W + 1];

        /*
         * tn: traversed n，即已经遍历过的物品
         * rw: reserved w，即背包还能容量的重量
         */
        for (int tn = 1; tn < N + 1; tn++) { // 遍历每一件物品
            for (int rw = 1; rw < W + 1; rw++) { // 背包容量有多大就还要计算多少次
                if (rw < w[tn]) {
                    // 当背包容量小于第tn件物品重量时，使用上一个物品的最大价值
                    dp[tn][rw] = dp[tn - 1][rw];
                } else {
                    // 当背包容量还大于第tn件物品重量时，进一步作出决策
                    // a. 放入这个物品前的最大价值 + 当前物品价值和作为答案
                    // b. 不放入这个物品时，当前容量的最大价值作为答案
                    dp[tn][rw] = Math.max(dp[tn - 1][rw], dp[tn - 1][rw - w[tn]] + v[tn]);
                }
            }
        }
        for (int[] x : dp) {
            System.out.println(Arrays.toString(Arrays.stream(x).toArray()));
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int N = 3, W = 5; // 物品的总数，背包能容纳的总重量
        int[] w = {0, 3, 2, 1}; // 物品的重量
        int[] v = {0, 5, 2, 3}; // 物品的价值
        System.out.println(dp(w, v, N, W));
    }
}
