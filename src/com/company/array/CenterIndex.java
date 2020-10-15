package com.company.array;
/*
* 寻找数组的中心索引
*
* 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
* 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
* 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
*
* */
public class CenterIndex {
    public static void main(String[] args) {
        int[] array = {-1, -1, -1, -1, 0, -1};
        int i = getCenterIndex(array);
        System.out.println("value " + i);
    }


    public static int getCenterIndex(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int size = nums.length;
        int leftSum = nums[0];
        int rightSum = nums[size -1];
        int leftIndex = 0;
        int rightIndex = size - 1;
        int firstSum = Integer.MAX_VALUE;

        int index = -1;
        int firstEqual = -1;
        boolean isFirst = true;

        do {
            if (rightSum == 0) {
                rightIndex--;
                rightSum += nums[rightIndex];
            }
            if (leftSum == 0) {
                leftIndex++;
                leftSum += nums[leftIndex];
            }
            if (leftSum == rightSum && isFirst) {
                firstEqual = leftIndex;
                firstSum = rightSum;
                isFirst = false;
            }
            if (leftSum > rightSum) {
                rightIndex--;
                rightSum += nums[rightIndex];
            } else if (leftSum < rightSum) {
                leftIndex++;
                leftSum += nums[leftIndex];
            } else {
                if (leftIndex == (rightIndex - 2)) {
                    index = leftIndex + 1;
                    break;
                } else {
                    leftIndex++;
                    leftSum += nums[leftIndex];
                    rightIndex--;
                    rightSum += nums[rightIndex];
                }
            }
        } while (leftIndex != rightIndex -1);

        if (firstSum == leftSum) {
            return firstEqual;
        }
        return index;
    }
}
