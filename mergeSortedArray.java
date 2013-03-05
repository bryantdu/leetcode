// leetcode.com/onlinejudge

// Given two sorted integer arrays A and B, merge B into A as one sorted array.

// Note:
// You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
       // System.out.println(m+ "  "+n);
        m--;
        n--;
        int index = A.length-1;
        while( m >=0 && n>=0)
        {
            if( A[m] > B[n])
                A[index--] = A[m--];
            else
                A[index--] = B[n--];
        }
        while(n>=0)
            A[index--]=B[n--];
    }
}