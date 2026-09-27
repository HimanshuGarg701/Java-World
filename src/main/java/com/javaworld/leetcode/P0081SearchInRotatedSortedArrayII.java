package com.javaworld.leetcode;

public class P0081SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) >>> 1;
            if (nums[middle] == target) return true;
            if (nums[low] == nums[middle] && nums[middle] == nums[high]) {
                low++;
                high--;
            } else if (nums[low] <= nums[middle]) {
                if (nums[low] <= target && target < nums[middle]) high = middle - 1;
                else low = middle + 1;
            } else {
                if (nums[middle] < target && target <= nums[high]) low = middle + 1;
                else high = middle - 1;
            }
        }
        return false;
    }
}

