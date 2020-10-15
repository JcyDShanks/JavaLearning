package com.company.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* leetcode 90
* 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
* 说明：解集不能包含重复的子集。
* */
public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int start = 1;
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> ans_tmp = new ArrayList<>();
            for (int j = 0; j < result.size(); j++) {
                // 获取上次添加的每个数组，并根据start来去掉不是上次新增的数组
                if (i > 0 && nums[i] == nums[i - 1] && j < start) {
                    continue;
                }
                List<Integer> temp = new ArrayList<>();
                temp.addAll(result.get(j));
                temp.add(nums[i]);
                ans_tmp.add(temp);
            }
            start = result.size();
            result.addAll(ans_tmp);
        }
        return result;
    }
}
