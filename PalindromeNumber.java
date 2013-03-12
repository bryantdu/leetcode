// leetcode.com/onlinejudge
// Determine whether an integer is a palindrome. Do this without extra space.

// Some hints:
// Could negative integers be palindromes? (ie, -1)

// If you are thinking of converting the integer to string, note the restriction of using extra space.

// You could also try reversing an integer. 
// However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. 
// How would you handle such case?

// There is a more generic way of solving this problem.

public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max =1;
        if (x<0)
            return false;
            
        if ( x/10 ==0)
            return true;
        
        int tmp = x;
        
        while(tmp >= 10)
        {
            tmp/=10;
            max*=10;
        }
        
        while (x >=10)
        {
            if ( x / max == x%10)
            {
                x%=max;
                x/=10;
                max/=100;
            }
            else
                return false;
        }
        return true;
    }
}