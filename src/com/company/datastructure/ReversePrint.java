package com.company.datastructure;

import com.company.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
* 剑指 Offer 06. 从尾到头打印链表
* 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
* */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();

        while (head != null) {
            res.add(0, head.val);
            head = head.next;
        }

        int[] arr = new int[res.size()];

        for (int i = 0; i < res.size(); i ++) {
            arr[i] = res.get(i);
        }

        return arr;
    }
}
