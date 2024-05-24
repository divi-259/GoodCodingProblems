import java.util.*;

/*Problem Statement: Binary search is a search algorithm usually used on a sorted sequence to quickly find an element with a given value. In this problem we will evaluate how binary search performs on data that isn't necessarily sorted. An element is said to be binary searchable if, regardless of how the pivot is chosen the algorithm returns true. For example:

[2, 1, 3, 4, 6, 5] and target = 5, we cannot find 5. Because when the pivot is 4, we get element 6, then right pointer will move left, so we'll lose the opportunity to find target 5.
[2, 1, 3, 4, 5, 6] and target = 5, we can find 5. Because wherever we choose the pivots, we'll find target at last.
Given an unsorted array of n distinct integers, return the number of elements that are binary searchable.
Problem Link: https://leetcode.com/discuss/interview-question/352743/Google-or-Onsite-or-Binary-Searchable-Numbers
*/

class BinarySearchable {

    public static void main(String[] args) {
        int arr[][] = {{1, 3, 2}, {2, 1, 3, 5, 4, 6}, {1, 5, 7, 11, 12, 18},{5, 4, 3, 2, 1, 0},  {1, 3, 2, 4, 5, 7, 6, 8}  };
        for(int a[] : arr) {
            System.out.println("Total Searchable elements are: " + count(a));
        }
    }

    private static int count(int arr[]) {
        // All the integers who are larger than all elements to its left and smaller than all elements to its right
        int maxleft[] = new int[arr.length];
        int minright[] = new int[arr.length];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int count = 0;

        for(int i=0; i<arr.length; i++) {
            maxleft[i] = Math.max(max, arr[i]);
            max = Math.max(max, arr[i]);
        }
        for(int i=arr.length-1; i>=0; i--) {
            minright[i] = Math.min(min, arr[i]);
            min = Math.min(min, arr[i]);
        }
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < maxleft[i])
            {
                count++;
                continue;
            }
            if(arr[i]>minright[i])
            {
                count++;
            }
        }
        return arr.length-count;
    }

}