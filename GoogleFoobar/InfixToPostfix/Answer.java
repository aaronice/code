package com.google.challenges;

import java.util.Stack;

public class Answer {
    public static String answer(String str)   {

        if (str == null || str.length() == 0) {
            return "";
        }
        String answerStr = "";
        int strLength = str.length();

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < strLength; i++) {
            char chr = str.charAt(i);
            if (chr != '*' && chr != '+') {
                answerStr += String.valueOf(chr);
            } else if (chr == '*') {
                stack.push(chr);
            } else if (chr == '+') {
                if (!stack.empty() && stack.peek() == '*') {
                    while (!stack.empty() && stack.peek() == '*') {
                        answerStr += String.valueOf(stack.pop());
                    }
                    stack.push(chr);
                } else {
                    stack.push(chr);
                }
            }
        }
        while (!stack.empty()) {
            answerStr += String.valueOf(stack.pop());
        }

        return answerStr;
    }

    public static void main(String[] args) {
        String str = "2*4*3+9*3+5";
        String answerStr = answer(str);
        System.out.println(answerStr);
    }
}
