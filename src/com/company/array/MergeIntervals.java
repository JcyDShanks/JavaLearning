package com.company.array;

import java.lang.reflect.Array;
import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] >= intervals[i+1][0]) {
                if (intervals[i][1] > intervals[i+1][1]) {
                    res.add(new int[]{intervals[i][0], intervals[i][1]});
                } else {
                    res.add(new int[]{intervals[i][0], intervals[i+1][1]});
                }
            } else {
                if (i > 0) {
                    if (res.get(res.size() - 1)[1] < intervals[i][1]) {
                        res.add(new int[]{intervals[i][0], intervals[i][1]});
                    }
                } else {
                    res.add(new int[]{intervals[i][0], intervals[i][1]});
                }
            }
        }
        return res.toArray(new int[0][]);
    }
}
