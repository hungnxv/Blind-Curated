package com.github;

import java.util.*;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * ---------------------------------------------------------------------------------------------------------------------
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByNumbers = new HashMap<>(nums.length);
        for(int i = 0; i< nums.length; i++) {
            indexByNumbers.put(nums[i], i);
        }
        int firstNumber;
        for(int i =0 ; i < nums.length; i++) {
            firstNumber = nums[i];
            int secondNumber = target - firstNumber;
            if(indexByNumbers.keySet().contains(secondNumber) && indexByNumbers.get(secondNumber) != i) {
                return new int[]{i, indexByNumbers.get(secondNumber)};
            }

        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println("[" + result[0] + ", "+ result[1] + "]");

        int[] result1 = twoSum(new int[]{3,2 ,4}, 6);
        System.out.println("[" + result1[0] + ", "+ result1[1] + "]");
    }

}
