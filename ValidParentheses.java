// leetcode.com/onlinejudge
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> left = new Stack<Character>();
        for(int i =0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            switch(ch)
            {
                case '(':
                    left.push(')');
                    break;
                case '{':
                    left.push('}');
                    break;
                case '[':
                    left.push(']');
                    break;
                default:
                    if(left.empty() || left.peek() != ch)
                        return false;
                    else
                        left.pop();
            }
        }
        if(!left.empty())
            return false;
        return true;
    }
}