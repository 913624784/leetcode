package com.github.qzw.offer;

/**
 * @author : qizhiwei
 * @date : 2021/4/16
 * @Description : https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class _4_二维数组中的查找 {
    /**
     * 时间复杂度 O(m+n)
     * 空间复杂度 O(1)
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //定义行列 线性查找
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}};
        System.out.println(findNumberIn2DArray(nums, 9));
    }
}
