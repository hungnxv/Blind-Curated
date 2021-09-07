package com.github;

/**
    https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        if(height.length == 0 || height.length == 1)
            return 0;
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        int area;
        while(left != right) {
            area = Math.min(height[left], height[right]) * (right - left);
            if (area > maxArea)
                maxArea = area;
            if(height[left] > height[right])
                right--;
            else
                left++;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[] {4,3,2,1,4}));
    }

}
