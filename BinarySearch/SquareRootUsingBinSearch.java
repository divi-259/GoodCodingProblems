/* Problem Statement: Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.
Problem Link: https://leetcode.com/problems/sqrtx/description/
Time complexity = O(logn)
*/

import java.util.*;

class SquareRootUsingBinSearch {

    public static void main(String args[]) {

        int testcases[] = {1,4,2,6,77,22,88,222,123,990,100000};
        for(int num : testcases) {
            System.out.println("Square root of " + num + " is " + getRoot(num));
        }

    }

    private static int getRoot(int num) {
        // we can guess the square root of num in range 1 to num
        if(num<=3)
            return 1;
        int lo = 1, hi = num;
        int sqrt = 0;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(mid*mid <= num) {
                lo = mid+1;
                sqrt = mid;
            }
            else hi = mid-1;
        }
        return sqrt;
    }





}