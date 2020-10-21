package com.company.datastructure;

import java.util.*;

public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer>  stack, minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if(minStack.empty() || minStack.peek() >= x) minStack.push(x);
        stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
