// leetcode.com/onlinejudge

// Implement atoi to convert a string to an integer.

// Hint: Carefully consider all possible input cases. 
// If you want a challenge, please do not see below and ask yourself what are the possible input cases.

// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
// You are responsible to gather all the input requirements up front.

// Requirements for atoi:
// The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
// Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
// and interprets them as a numerical value.

// The string can contain additional characters after those that form the integral number, 
// which are ignored and have no effect on the behavior of this function.

// If the first sequence of non-whitespace characters in str is not a valid integral number, 
// or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

// If no valid conversion could be performed, a zero value is returned. 
// If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (str.length()==0)
            return 0;
        boolean start = false;
        boolean sign = true;
        int result = 0;
        
        for ( int i =0; i < str.length(); i ++)
        {
            char ch = str.charAt(i);
            switch(ch)
            {
                case '+':
                    if (start)
                        return 0;
                    else
                        start = true;
                    break;
                case '-':
                    if (start)
                        return 0;
                    else
                    {
                        start = true;
                        sign = false;
                    }
                    break;
                case ' ':
                    if (start)
                        return sign? result : result*(-1);
                    break;
                default:
                    if (ch < '0' || ch > '9')
                    {
                        if(start)
                            return sign? result : result*(-1);
                        else return 0;
                    }
                    else
                    {
                        start = true;
                        int tmp = Integer.parseInt(Character.toString(ch));
                        if ( result > (Integer.MAX_VALUE - tmp)/10 )
                            return sign? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        result *= 10;
                        result+= tmp;
                    }
            }
             
        }
        return sign? result : result*(-1);
    }
}