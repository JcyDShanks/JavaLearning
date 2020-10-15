package com.company.array;

/*
* 153. 寻找旋转排序数组中的最小值
* 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
* ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
* 请找出其中最小的元素。
* 你可以假设数组中不存在重复元素。
* */
public class FindMinInRevertNums {
    public int findMin(int[] nums) {
        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < start) return nums[i];
        }
        return start;
    }
}
