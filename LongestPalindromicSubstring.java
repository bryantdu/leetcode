// leetcode.com/onlinejudge
// Given a string S, find the longest palindromic substring in S. 
// You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if (s.length() ==1 || s.length() == 0)
           return s;
        int max=0;
        int[] result = new int[2];
        for( int i =0; i < s.length() - max; i++)
        {
            for( int j = i+max; j < s.length(); j++)
            {
                if ( isPalindrome(s, i,j))
                {
                    if ( max < (j-i+1))
                    {
                        result[0] = i;
                        result[1] = j+1;
                        max = j-i+1;
                    }
                }
            }   
        }
        return s.substring(result[0], result[1]);
    }
    public boolean isPalindrome(String s, int start, int end)
    {
        for ( int i = start, j = end; i < j; i++, j --)
        {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}