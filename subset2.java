//http://leetcode.com/onlinejudge
// Given a collection of integers that might contain duplicates, S, return all possible subsets.

// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,2], a solution is:

// [
  // [2],
  // [1],
  // [1,2,2],
  // [2,2],
  // [1,2],
  // []
// ]

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if ( num.length ==0)
            return null;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        for( int i =0; i < num.length; i++)
        {
            ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
            tmp.addAll(result);
            for(int j =0; j<tmp.size(); j++)
            {
                ArrayList<Integer> set = new ArrayList<Integer>();
                set.addAll(tmp.get(j));
                set.add(num[i]);
                if(!result.contains(set))
                    result.add(set);        
            }
        }
        return result;
    }
}