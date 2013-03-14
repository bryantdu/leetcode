// leetcode.com/onlinejudge
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        if(n ==0)
            return result;
        generate(n,n,"",result);
        return result;
    }
    public void generate(int left, int right, String s, ArrayList<String> re)
    {
        if (left==0 && right==0)
        {
            re.add(s);
            return;
        }
        if(left>0)
            generate(left-1,right,s+"(",re);
        if(left < right)
            generate(left,right-1,s+")",re);
    }
}