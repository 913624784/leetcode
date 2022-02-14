package com.github.qzw.dynamic_programming;

import java.util.Arrays;

/**
 * @Author: qizhiwei
 * @date: 2022/2/14
 * @PackageName: com.github.qzw.dynamic_programming
 * @Description: 问题：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例：
 * <p>
 * 输入：[-2, 1, -3, 4, -1, 3, -5, 1, 2]
 * 输出：6
 * 解释：连续子数组 [4,-1, 3] 的和最大为 6
 */
public class _6_最大子数组之和 {

    /**
     * 方案一
     */
    static int maxSubArray1(int[] nums) {
        int n = nums.length;
        if (0 == n) {
            return 0;
        }
        // 初始化状态
        int[] dp = new int[n];
        dp[0] = nums[0];

        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(Arrays.stream(dp).toArray()));

        return res;
    }

    /**
     * 方案二 空间复杂度优化
     */
    static int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (0 == n) {
            return 0;
        }
        int dp_0 = nums[0], dp_1; // 初始化状态

        int res = dp_0;
        for (int i = 1; i < n; i++) {
            dp_1 = Math.max(nums[i], dp_0 + nums[i]);
            dp_0 = dp_1;
            res = Math.max(res, dp_1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 3, -5, 1, 2};
        System.out.println("/** 方案一 **/");
        System.out.println(maxSubArray1(nums));
        System.out.println("/** 方案二 **/");
        System.out.println(maxSubArray2(nums));
    }
}
