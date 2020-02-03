package Lesson5and6;

import java.util.LinkedList;
import java.util.Stack;

public class StackPractice {

    //Leetcode problem 20
    static class Solution {
        boolean isValid(String s) {
            LinkedList<Character> string = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if ((s.charAt(i) == '(') || (s.charAt(i) == '{') || (s.charAt(i) == '[')) {
                    string.push(s.charAt(i));
                } else {
                    if (string.isEmpty()) return false;
                    if (s.charAt(i) == ')') {
                        if (string.peek() != '(') return false;
                        else string.pop();
                    } else if (s.charAt(i) == '}') {
                        if (string.peek() != '{') return false;
                        else string.pop();
                    } else if (s.charAt(i) == ']') {
                        if (string.peek() != '[') return false;
                        else string.pop();
                    }
                }
            }
            if (string.isEmpty())
            return true;
            else return false;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3,4 ,5, 6, 7};

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

}
