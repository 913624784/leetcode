package com.github.qzw.leetcode_top100;

import java.util.Arrays;

/**
 * @author : qizhiwei
 * @date : 2023/10/6
 * @Description : https://leetcode.cn/problems/merge-sorted-array/description/
 */
public class _88_合并两个有序数组 {
    /**
     * 合并 num2 到 num1
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1, num1index = m - 1, num2index = n - 1; i >= 0; i--) {
            if (num1index < 0) {// num1 取完直接拿 num2
                nums1[i] = nums2[num2index--];
            } else if (num2index < 0) {// num2 取完就结束
                break;
            } else if (nums1[num1index] > nums2[num2index]) {
                nums1[i] = nums1[num1index--];
            } else {
                nums1[i] = nums2[num2index--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 0, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 4, 6, 7, 8};
        int n = 5;
        merge(nums1, m, nums2, n);
    }
}
