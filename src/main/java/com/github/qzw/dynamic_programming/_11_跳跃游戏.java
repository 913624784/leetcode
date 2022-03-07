package com.github.qzw.dynamic_programming;

import java.util.Arrays;

/**
 * @Author: qizhiwei
 * @date: 2022/3/7
 * @PackageName: com.github.qzw.dynamic_programming
 * @Description: 给出一个非负整数数组 A，你最初定位在数组的第一个位置。数组中的每个元素代表你在那个位置可以跳跃的最大长度。判断你是否能到达数组的最后一个位置
 * 示例1：
 * <p>
 * 输入：A = [2, 3, 1, 1, 6]
 * 输出： True
 * 解释: 我们可以先跳 1 步，从位置 0 到达位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例2：
 * <p>
 * 输入：A = [4, 2, 1, 0, 0, 6]
 * 输出： False
 * 解释: 无论从开头怎么跳跃，你最多都只能到达位置 3 或位置 4，但这两个位置的最大跳跃长度是 0，所以你永远不可能到达最后一个位置。
 */
public class _11_跳跃游戏 {

    //DP[i] 来表示能否从出发点到达位置 i
    static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return true;
        }

        boolean[] dp = new boolean[n];
        // 初始化状态
        for (int i = 0; i < n; i++) {
            dp[i] = false;
        }
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) { // j < i
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1]; // 输出答案
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 0, 0, 6};
        System.out.println(canJump(nums));
    }
}
