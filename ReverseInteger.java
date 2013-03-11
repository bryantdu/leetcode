// leetcode.com/onlinejudge
// Reverse digits of an integer.

// Example1: x = 123, return 321
// Example2: x = -123, return -321

public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result =0;
        result = x%10;
        x /=10;
        while ( x!=0)
        {
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        return result;
    }
}