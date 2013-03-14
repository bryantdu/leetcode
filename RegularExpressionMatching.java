// leetcode.com/onlinejudge

// Implement regular expression matching with support for '.' and '*'.

// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") ? false
// isMatch("aa","aa") ? true
// isMatch("aaa","aa") ? false
// isMatch("aa", "a*") ? true
// isMatch("aa", ".*") ? true
// isMatch("ab", ".*") ? true
// isMatch("aab", "c*a*b") ? true
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p.equals(".*"))
            return true;
        return isMatch(s,0,p,0);
    }
    public boolean isMatch(String s, int sindex, String p, int pindex)
    {
        // P reach end
        if(pindex == p.length())
            return sindex==s.length();
        // S reach end
        if(sindex == s.length())
        {
            // deal with *
            if(pindex <= p.length() -2)
            {
                if(p.charAt(pindex+1) == '*')
                    return isMatch(s,sindex,p,pindex+2);
                else
                    return false;
            }
            else
                return false;         
        }
        
        // no * left situation
        if(pindex == p.length()-1)
        {
            if((sindex< s.length()-1) || s.charAt(sindex)!= p.charAt(pindex) && p.charAt(pindex)!= '.') 
                return false;
            else
                return true;     
        }
        
        // P next is not *
        if(p.charAt(pindex+1)!='*')
        {
            if(s.charAt(sindex) != p.charAt(pindex) && p.charAt(pindex)!= '.')
                return false;
            return isMatch(s,sindex+1,p,pindex+1);  
        }
        // P next is *
        else
        {
            //No match with *, jump *
            if(s.charAt(sindex)!= p.charAt(pindex) && p.charAt(pindex)!='.')
                return isMatch(s,sindex,p,pindex+2);
            else
            {
                // Match with *, recursion check
                while(sindex<s.length() && (s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '.'))
                {
                    if(isMatch(s,sindex,p,pindex+2))
                        return true;
                    sindex++;
                }
                return isMatch(s,sindex,p,pindex+2);
            }
        }
    }
}