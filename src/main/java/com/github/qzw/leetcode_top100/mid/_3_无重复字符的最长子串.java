package com.github.qzw.leetcode_top100.mid;

import java.util.HashMap;

/**
 * @author : qizhiwei
 * @date : 2021/4/26
 * @Description : https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class _3_无重复字符的最长子串 {
    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(<n)
     */
    public static int lengthOfLongestSubstring(String s) {
        //key为具体字符的值 value 为该值的下标
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        int max = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                System.out.println("->    " + ch + " , i: " + i + ", start: " + start + ", max: " + max);
                //避免取到较小的下标 如果直接赋值，会出现问题 例如：abba
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, i - start + 1);
            System.out.println("char: " + ch + " , i: " + i + ", start: " + start + ", max: " + max);
            //同字符会更新为最新的字符下标
            map.put(ch, i);
        }
        System.out.println(map);
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("abcdafghemnca"));
    }

}
