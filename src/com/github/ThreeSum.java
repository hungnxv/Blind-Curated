package com.github;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Integer previous = null;
        List<List<Integer>> result = new LinkedList<>();
        for(int i = 0; i < nums.length-2; i++) {
            if(Integer.valueOf(nums[i]).equals(previous))
                continue;
            int left = i + 1, right = nums.length- 1;

            while (left != right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int previousLeft = left;
                    left++;
                    while (nums[left] == nums[previousLeft] && left < right)
                        left++;



                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
            previous = nums[i];

        }

        return result;
    }

    public static void main(String[] args) {
//        List<List<Integer>> result = threeSum(new int[] {-1,0,1,2,-1,-4});
//        List<List<Integer>> result = threeSum(new int[] {-4,0,1,2,-1,2,3});
//        List<List<Integer>> result = threeSum(new int[] {0,0,0,0});
        List<List<Integer>> result = threeSum(new int[] {-1,0,1,2,-1,-4});



        for(List<Integer> threeSum: result) {
            System.out.println(threeSum);
        }
    }
}
