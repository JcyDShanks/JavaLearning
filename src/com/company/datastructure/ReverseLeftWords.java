package com.company.datastructure;


/*
* 剑指 Offer 58 - II. 左旋转字符串
* 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
* 请定义一个函数实现字符串左旋转操作的功能。
* 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
* */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
        }
        for (int j = 0; j < n; j++) {
            stringBuilder.append(s.charAt(j));
        }
        return stringBuilder.toString();
    }
}
