//http://leetcode.com/onlinejudge
// Given a set of distinct integers, S, return all possible subsets.

// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,3], a solution is:

// [
  // [3],
  // [1],
  // [2],
  // [1,2,3],
  // [1,3],
  // [2,3],
  // [1,2],
  // []
// ]
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if ( S.length ==0)
            return null;
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int sum = 1 << S.length;
        for (int i =0; i < sum; i++)
        {
            int current = i;
            int index =0;
            ArrayList<Integer> set = new ArrayList<Integer>();
            while ( current > 0)
            {
                if( (current & 1) == 1)
                    set.add(S[index]);
                index++;
                current >>=1;
            }
            result.add(set);
        }
        return result;
    }
}