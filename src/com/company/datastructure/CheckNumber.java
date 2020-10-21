package com.company.datastructure;

import java.util.HashMap;
import java.util.Map;

/*
* 剑指 Offer 20. 表示数值的字符串
*
* 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
* 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
*
* 解题思路：使用有限状态自动机
* 根据字符类型和合法数值的特点，先定义状态，再画出状态转移图
*
* 字符类型：空格 「 」、数字「 0—90—9 」 、正负号 「 ++, -− 」 、小数点 「 .. 」 、幂符号 「 ee, EE 」 。
* 状态定义：
* 按照字符串从左到右的顺序，定义以下 9 种状态。
* 1. 开始为空格
* 2. 幂符号前的正负号 合法
* 3. 小数点前的数字 合法
* 4. 小数点、小数点后的数字
* 5. 当小数点前为空格时，小数点、小数点后的数字
* 6. 幂符号
* 7. 幂符号后的正负号
* 8. 幂符号后的数字
* 9. 结尾的空格
*
* 空格对应 ' '
* 正负号对应 's'
* 数字对应 'd'
* 小数点对应 '.'
* 幂符号对应 'e'
* */
public class CheckNumber {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<>() {{ put('d', 3); }},                                        // 4.
                new HashMap<>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<>() {{ put('d', 7); }},                                        // 6.
                new HashMap<>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
