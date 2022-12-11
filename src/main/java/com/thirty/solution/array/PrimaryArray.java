package com.thirty.solution.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年12月11日
 * @since: 1.0.0
 */
public class PrimaryArray {


    /*
     *
     *  方法1： 快慢指针解决数组相关算法
     *
     *
     * * */


    /**
     * @Leetcode 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，
     * 在数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 假设只有一个答案。但是，数组中同一个元素在答案里不能重复出现。
     */

    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (res.containsKey(target - arr[i])) {
                return new int[]{res.get(i), i};
            }
            res.put(arr[i], i);
        }
        return null;
    }


    /**
     * @Leetcode 26. 删除数组重复元素
     * 升序排列 的数组nums ，请原地 删除重复出现的元素，使每个元素 只出现一次 ，返回数组长度。
     * 并在使用 O(1) 额外空间的条件下完成
     * <p>
     * 思路：快慢指针
     * 慢指针 slow 走在后面，快指针 fast 走在前面探路，找到一个不重复的元素就赋值给 slow 并让 slow 前进一步。
     * 这样，就保证了 nums[0..slow] 都是无重复的元素，当 fast 指针遍历完整个数组 nums 后，
     * nums[0..slow] 就是整个数组去重之后的结果。
     */

    public static int deleteRepeat(int[] arr) {
        int slow = 0, fast = 0;
        while (fast < arr.length) {
            if (arr[fast] != arr[slow]) {
                slow++;
                arr[slow] = arr[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    /**
     * 把 nums 中所有值为 val 的元素原地删除，
     * 使用快慢指针：如果 fast 遇到值为 val 的元素，则直接跳过，否则就赋值给 slow 指针，并让 slow 前进一步。
     * 和前面数组去重问题解法思路是完全一样的
     */
    public static int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * @Leetcode 28 移动0
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 思路同上，将数组元素为0的元素移除，将尾部元素置为 0
     */
    public static int[] removeZero(int[] nums) {
        int i = removeElement(nums, 0);
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }


    /*
     *
     *   方法2： 左右指针(双指针)的常用算法；数组有序就应该想到双指针技巧
     *       二分查找
     *
     * * */


    /**
     * 二分查找，有序数组中，查找target元素
     */
    public static int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] > target) {
                left = mid + 1;
            }
            if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }


    /**
     * @Leetcode 两数之和  有序数组
     * 给一个下标从 1 开始的整数数组 numbers ，该数组已按非递减顺序排列  ，
     * 从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
     * 必须只使用常量级的额外空间。
     *
     * 有序数组使用双指针
     */

    public static int[] twoSum02(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 5, 7};
        System.out.println(Arrays.toString(twoSum02(nums, 7)));

    }
}
