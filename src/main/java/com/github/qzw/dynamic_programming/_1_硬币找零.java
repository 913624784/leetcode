package com.github.qzw.dynamic_programming;

import java.util.Arrays;

/**
 * @Author: qizhiwei
 * @date: 2022/2/8
 * @PackageName: com.github.qzw.dynamic_programming
 * @Description: 动态规划
 * 问题：给定n种不同面值的硬币，分别记为c[0], c[1], c[2], … c[n]，同时还有一个总金额k，编写一个函数计算出最少需要几枚硬币凑出这个金额k？
 * 每种硬币的个数不限，且如果没有任何一种硬币组合能组成总金额时，返回 -1
 * 示例 1：
 * <p>
 * 输入：c[0]=1, c[1]=2, c[2]=5, k=12
 * 输出：3
 * 解释：12 = 5 + 5 + 2
 * 示例 2：
 * <p>
 * 输入：c[0]=5, k=7
 * 输出：-1
 * 解释：只有一种面值为5的硬币，怎么都无法凑出总价值为7的零钱
 */
public class _1_硬币找零 {

    /**
     * 自底向上算每个面额的最优解
     * 复杂度O(M*n)
     *
     * @param k      总额
     * @param values 面值列表
     * @return 最小组合
     */
    static int getMinCounts(int k, int[] values) {
        int[] memo = new int[k + 1]; // 创建备忘录
        memo[0] = 0; // 初始化状态
        for (int i = 1; i < k + 1; i++) {
            memo[i] = k + 1;
        }

        for (int i = 1; i < k + 1; i++) {
            for (int coin : values) {
                // 判断当前面额总值是否小于当前硬币面额。如果是，则说明组合不存在，直接进入下一轮循环
                if (i - coin < 0) {
                    continue;
                }
                // a. 如果采纳了这枚硬币，则凑的硬币数量需要 +1，这时“状态A”是 memo[i - coin] + 1；
                // b. 如果不采纳这枚硬币，则凑的硬币数量不变，这时“状态B”是 memo[i]；
                // c. 显然，硬币找零问题是求最值问题（即最少需要几枚硬币凑出总额k）。因此，我们在这里作出决策，在状态A与状态B中谁的硬币数量更少，即取最小值 min(状态A, 状态B)
                memo[i] = Math.min(memo[i], memo[i - coin] + 1); // 作出决策
            }
        }

        // 当循环结束后，我们看一下备忘录中位置为 k 的值是多少，即 memo[k]
        // a. 如果是 k + 1，就意味着在初始化状态时的值没有被更新过，是“正无穷大”。这时按照题目要求，返回 -1
        // b. 否则，我们就找到了最少凑出硬币的数量，返回它，就是我们的答案
        System.out.println(Arrays.toString(Arrays.stream(memo).toArray()));
        return memo[k] == k + 1 ? -1 : memo[k];
    }

    public static void main(String[] args) {
        int[] values = {5, 3}; // 硬币面值
        int total = 11; // 总价
        System.out.println(getMinCounts(total, values));
    }
}
