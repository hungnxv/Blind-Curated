package com.github;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private static final Map<Character, Character> closeToOpen = new HashMap<>(3);
    static  {
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');
        closeToOpen.put(')', '(');

    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(closeToOpen.values().contains(c))
                stack.push(c);
            else if(closeToOpen.keySet().contains(c)) {
                if(stack.empty())
                    return false;
                if(closeToOpen.get(c) == stack.peek())
                    stack.pop();
                else
                    stack.push(c);
            }

        }

        return stack.empty();
    }

    public static void main(String[] args) {
//        System.out.println(isValid("("));
//        System.out.println(isValid("([)]"));
        System.out.println(isValid("(])"));



    }

}
