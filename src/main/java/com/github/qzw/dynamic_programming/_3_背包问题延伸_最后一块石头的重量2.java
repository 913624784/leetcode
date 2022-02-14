package com.github.qzw.dynamic_programming;

import java.util.Arrays;

/**
 * @Author: qizhiwei
 * @date: 2022/2/9
 * @PackageName: com.github.qzw.dynamic_programming
 * @Description: 背包问题延伸
 * 问题：有一堆石头，每块石头的重量都是正整数。每次从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x ≤ y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x 与 y 相等，那么两块石头都会被完全粉碎；
 * 否则，重量为 x 的石头将会完全粉碎，而重量为 y 的石头的新重量为 y - x。
 * 最后，最多只会剩下一块石头。返回此时石头最小的可能重量。如果没有石头剩下，就返回 0。
 * <p>
 * 示例：
 * 输入：[1, 2, 1, 7, 9, 4]
 * 输出：
 * Round 1: (2, 4) -> 2, 数组变成 [1, 1, 7, 9, 2]
 * Round 2: (7, 9) -> 2, 数组变成 [1, 1, 2, 2]
 * Round 3: (2, 2) -> 0, 数组变成 [1, 1]
 * Round 4: (1, 1) -> 0, 数组为空，返回 0
 * Tips：
 * 现在，假设有一个背包，背包的容量是 12（24/2）。接着，我们有一堆的物品，重量分别是 [1, 2, 1, 7, 9, 4]，注意我们设它的价值与重量相同。
 * 现在我们希望选出的物品放到背包里的价值最大，这样一来，我们就可以把这个题目转化成0-1背包问题了
 */
public class _3_背包问题延伸_最后一块石头的重量2 {
    static int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();

        //背包容量上限为石头总重量的一半
        int[][] dp = new int[n + 1][sum / 2 + 1];
        /*
         * tn: traversed n，即已经遍历过的石头
         * rw: reserved w，即背包还能容量的重量
         */
        for (int tn = 1; tn < n; tn++) {
            for (int rw = 1; rw < sum / 2 + 1; rw++) {
                if (rw < stones[tn]) {
                    //这块石头放不进背包时，只能跳过
                    dp[tn][rw] = dp[tn - 1][rw];
                } else {
                    //当我能把这块石头放进背包时，我会比较放或不放，选择最大值
                    dp[tn][rw] = Math.max(dp[tn - 1][rw], dp[tn - 1][rw - stones[tn]] + stones[tn]);
                }
            }
        }
        for (int[] x : dp) {
            System.out.println(Arrays.toString(Arrays.stream(x).toArray()));
        }
        return sum - dp[n - 1][sum / 2] * 2;
    }

    public static void main(String[] args) {
        int[] stones = {1, 2, 1, 7, 9, 4};
        System.out.println(lastStoneWeightII(stones));
    }
}
