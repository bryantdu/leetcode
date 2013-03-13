// leetcode.com/onlinejudge
// Write a function to find the longest common prefix string amongst an array of strings.

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length ==0)
            return "";
        String result = strs[0];
        for( int i =1; i <strs.length; i++)
        {
            int index = findFirstDiff(result,strs[i]);
            if (index!= -1)
            {
                result=result.substring(0,index);
            }
        }
        return result;
    }
    public int findFirstDiff(String a, String b)
    {
        for(int i =0; i<a.length() && i<b.length();i++)
        {
            if(a.charAt(i) != b.charAt(i))
                return i;
        }
        if( b.length()< a.length())
            return b.length();
        return -1;
    }
}