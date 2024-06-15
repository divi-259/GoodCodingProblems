import java.util.*;

/*
Question Link: https://www.geeksforgeeks.org/minimize-maximum-array-element-possible-by-at-most-k-splits-on-the-given-array/

Given an array arr[] consisting of N positive integers and a positive integer K, the task is to minimize the maximum element present 
in the array by splitting at most K array elements into two numbers equal to their value.
Input: arr[] = {2, 4, 8, 2}, K = 4
Output: 2
Input: arr[] = {7, 17}, K = 2
Output: 7

Binary search to the rescue. We are going to check in the array if there is an integer to which we can reduce all the numbers to,
the min integer we need, and we need to find that integer within k steps.
*/

class GetMinAfterSplit {
    public static void main(String args[]) {
        int test1[] = {2,4,8,2};
        int test2[] = {7,17};
        System.out.println("Min element to reduce to is = " + getMin(test1, 4));
        System.out.println("Min element to reduce to is = " + getMin(test2, 2));
    }

    private static int getMin(int arr[], int k) {
        Arrays.sort(arr);
        int lo = 1, hi = arr[arr.length-1];
        
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            // to check if all elements can be reduced to mid value 
            if(calculate(arr, mid, k)) {
                hi = mid; // then we gotta find a min solution
            }
            else lo = mid+1;
        }

        return hi;
    }

    private static boolean calculate(int arr[], int mid, int k) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            count += (arr[i]-1)/mid;
        }
        if(count <= k)
            return true;
        else return false;
    }
}