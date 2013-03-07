// leetcode/onlinejudge

// There are two sorted arrays A and B of size m and n respectively. 
// Find the median of the two sorted arrays. 
// The overall run time complexity should be O(log (m+n)).

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length = A.length + B.length;
        if (length%2 ==1)
            return findKth(A,0,A.length,B,0,B.length, length/2+1);
        else
            return (findKth(A,0,A.length,B,0,B.length, length/2)+findKth(A,0,A.length,B,0,B.length, length/2+1))/2;
        
    }
    double findKth(int[] a, int aindex, int asize,int[] b, int bindex, int bsize,int k)
    {
        if (asize> bsize)
            return findKth(b,bindex,bsize,a,aindex,asize,k);
        if (asize ==0)
            return b[bindex+k-1];
        if (k==1)
            return Math.min(a[aindex],b[bindex]);
        int amove = Math.min(asize, k/2);
        int bmove = k-amove;
        if (a[aindex+amove-1] < b[bindex+bmove-1])
            return findKth(a,aindex+amove,asize-amove,b,bindex,bsize,k-amove);
        else
            return findKth(a,aindex,asize,b,bindex+bmove,bsize-bmove,k-bmove);
    }
}