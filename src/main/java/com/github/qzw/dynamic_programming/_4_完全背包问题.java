package com.github.qzw.dynamic_programming;

import java.util.Arrays;

/**
 * @Author: qizhiwei
 * @date: 2022/2/14
 * @PackageName: com.github.qzw.dynamic_programming
 * @Description: 问题：给你一个可放总重量为 W 的背包和 N 个物品，对每个物品，有重量 w 和价值 v 两个属性，那么第 i 个物品的重量为 w[i]，价值为 v[i]
 * 现在让你用这个背包装物品，每种物品都可以选择任意多个，问这个背包最多能装的价值是多少？（比背包问题多的是每种物品可以选择任意多个）
 * <p>
 * 示例：
 * <p>
 * 输入：W = 5, N = 3
 * w = [3, 2, 1], v = [5, 2, 3]
 * 输出：15
 * 解释：当 i = 2 时，选取 5 次，总价值为 5 * 3 = 15。
 */
public class _4_完全背包问题 {

    /**
     * 方案一
     * 复杂度O(NW^2)
     * 0-1背包问题：针对当前物品，是放入背包，还是不放入背包时的价值最大
     * 完全背包问题：针对当前物品，应放入多少件当前物品，价值最大
     */
    static int bag1(int[] w, int[] v, int N, int W) {
        // 创建备忘录
        int[][] dp = new int[N + 1][W + 1];

        // 遍历每一件物品
        for (int tn = 1; tn < N + 1; tn++) {
            // 背包容量有多大就还要计算多少次
            for (int rw = 1; rw < W + 1; rw++) {
                dp[tn][rw] = dp[tn - 1][rw];
                // 根据rw尝试放入多次物品，从中找出最大值，作为当前子问题的最优解
                for (int k = 0; k <= rw / w[tn]; k++) {
                    dp[tn][rw] = Math.max(dp[tn][rw], dp[tn - 1][rw - k * w[tn]] + k * v[tn]);
                }
            }
        }
        for (int[] x : dp) {
            System.out.println(Arrays.toString(Arrays.stream(x).toArray()));
        }
        return dp[N][W];
    }

    /**
     * 方案二 时间复杂度优化
     * 复杂度O(NW)
     */
    static int bag2(int[] w, int[] v, int N, int W) {
        // 创建备忘录
        int[][] dp = new int[N + 1][W + 1];

        // 遍历每一件物品
        for (int tn = 1; tn < N + 1; tn++) {
            // 背包容量有多大就还要计算多少次
            for (int rw = 1; rw < W + 1; rw++) {
                dp[tn][rw] = dp[tn - 1][rw];
                // 如果可以放入，则尝试放入第tn件物品
                if (w[tn] <= rw) {
                    dp[tn][rw] = Math.max(dp[tn][rw], dp[tn][rw - w[tn]] + v[tn]);
                }
            }
        }
        for (int[] x : dp) {
            System.out.println(Arrays.toString(Arrays.stream(x).toArray()));
        }
        return dp[N][W];
    }

    /**
     * 方案三 空间复杂度优化
     * 从状态转移方程中，我们可以知道：如果想求 DP(tn, rw)，那么我们只依赖于DP(tn-1, rw)和DP(tn, 0)
     * 因为我们只关心tn-1时的结果和tn相同时的结果 也就是说，当前的计算只使用缓存中当前这一行和上一行的计算结果
     * 可以采用滚动数据，定义一个只有两行的数组
     * 在计算第 1 个物品时，用第 0 行做 tn - 1 的缓存，用第 1 行做 tn 的缓存
     * 在计算第 2 个物品时，用第 1 行做 tn - 1 的缓存，用第 0 行做 tn 的缓存
     * 在计算第 3个物品时，用第 0 行做 tn - 1 的缓存，而用第 1 行做 tn 的缓存……以此类推
     */
    static int bag3(int[] w, int[] v, int N, int W) {
        // 创建备忘录
        int[][] dp = new int[2][W + 1];

        //遍历每一件物品
        for (int tn = 1; tn < N + 1; tn++) {
            // 背包容量有多大就还要计算多少次
            for (int rw = 1; rw < W + 1; rw++) {
                // tn % 2代表当前行的缓存索引
                int ctn = tn % 2;
                // 1 - ctn代表上一行的缓存索引
                int ptn = 1 - ctn;

                dp[ctn][rw] = dp[ptn][rw];
                // 如果可以放入则尝试放入第tn件物品
                if (w[tn] <= rw) {
                    dp[ctn][rw] = Math.max(dp[ctn][rw], dp[ctn][rw - w[tn]] + v[tn]);
                }
            }
        }
        for (int[] x : dp) {
            System.out.println(Arrays.toString(Arrays.stream(x).toArray()));
        }
        return dp[N % 2][W];
    }

    public static void main(String[] args) {
        int N = 3, W = 5; // 物品的总数，背包能容纳的总重量
        int[] w = {0, 3, 2, 1}; // 物品的重量
        int[] v = {0, 5, 2, 3}; // 物品的价值
        System.out.println("/** 方案一 **/");
        System.out.println(bag1(w, v, N, W));
        System.out.println("/** 方案二 **/");
        System.out.println(bag2(w, v, N, W));
        System.out.println("/** 方案三 **/");
        System.out.println(bag3(w, v, N, W));
    }
}
