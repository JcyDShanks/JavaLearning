package com.company.datastructure;

import java.util.LinkedList;
import java.util.Stack;

/*
* 剑指 Offer 09. 用两个栈实现队列
*
* 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
* 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
* */
public class CQueue {

    Stack<Integer> A, B;

    public CQueue() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void appendTail(int value) {
        A.add(value);
    }

    public int deleteHead() {
        if(B.isEmpty() && A.isEmpty()) return -1;
        if(!B.isEmpty()) return B.pop();
        while (!A.isEmpty()) {
            B.add(A.pop());
        }
        return B.pop();
    }
}
