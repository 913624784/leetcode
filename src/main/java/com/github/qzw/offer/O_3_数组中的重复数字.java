package com.github.qzw.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : qizhiwei
 * @date : 2021/4/16
 * @Description : https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class O_3_数组中的重复数字 {

    /**
     * 时间空间复杂度都为 O(n)
     */
    public static int findRepeatNumber(int[] nums) {
        int result = -1;
        Set<Integer> set = new HashSet<>();
        for (int ele : nums) {
            if (!set.add(ele)) {
                result = ele;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 5, 6, 7, 1};
        System.out.println(findRepeatNumber(nums));
    }
}
