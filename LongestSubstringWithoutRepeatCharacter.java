// leetcode.com/onlinejudge
// Given a string, find the length of the longest substring without repeating characters. 
// For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
// For "bbbbb" the longest substring is "b", with the length of 1.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (s.length()==0)
            return 0;
        int[] character = new int[26];
        int result = 0;
        int count =0;
        int current =0;
        for ( int i =0; i < s.length();)
        {
            int pos = 'z' - s.charAt(i);
            if(check(count,pos))
            {
                count =0;
                current = 0;
                i = character[pos]+1;
            }
            else
            {
                count |= (1 << pos);
                character[pos] = i;
                current++;
                if(current > result)
                    result = current;
                if(i == s.length()-1)
                    return result;
                i++;
            }
        }
        return result;
    }
    public boolean check(int count, int pos)
    {
        if (( count>>pos & 0x1) ==1)
            return true;
        else
            return false;
    }
}