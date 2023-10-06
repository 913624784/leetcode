package com.github.qzw.leetcode_top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : qizhiwei
 * @date : 2021/4/26
 * @Description : https://leetcode-cn.com/problems/two-sum/
 */
public class _1_两数之和 {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("没有该组合！");
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
