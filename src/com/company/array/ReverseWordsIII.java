package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 557. 反转字符串中的单词 III
* 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
* */
public class ReverseWordsIII {
    public String reverseWords(String s) {
        if (s.length() == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;

        while (start < s.length()) {
            if (s.charAt(start) == ' ') {
                stringBuilder.append(' ');
                start++;
                continue;
            } else {
                int end = start;
                StringBuilder temp = new StringBuilder();
                while (end < s.length() && s.charAt(end) != ' ') {
                    temp.append(s.charAt(end));
                    end++;
                }
                stringBuilder.append(temp.reverse());
                start = end;
            }
        }
        return stringBuilder.toString();
    }
}
