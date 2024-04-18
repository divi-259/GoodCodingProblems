/*Problem Statement :
Asked by Flipkart.

Original link - https://leetcode.com/discuss/interview-question/5036763/OAFlipkart

Solution understood from one of the user's comment

Given two integers n and k,rearrange all numbers between 1 and n such that sum of each segment of k consecutive integers in the rearranged pattern does not differ by more than 1.
eg n=2,k=2
[1,2]
eg n=7 k=4
[1,7,3,5,2,6,4]

Solution:
eg : n = 10, k = 3
so in forward direction just increment numbers starting from 1 after every k gap. if no further numbers can be added so now change the direction 
and add numbers from reverse that is 'n' and decrement it as going forward with a gap of k. and we add numbers from reverse because, 
we want each array to have a mixture of max and min values alternatively so that the average of all subarrays remain close to each other.

=> [1, _ , _ , 2 , _ , _, 3 , _, _, 4] (go in right and increment with a gap of k) (1 -> 2 -> 3 -> 4)
=> [1, 10 , _ , 2 , 9 , _, 3 , 8, _, 4] (go in right and decrement with a gap of k) (10 -> 9 -> 8)
=> [1, 10 , 5 , 2 , 9 , 6, 3 , 8, 7, 4](go in right and increment with a gap of k) (5 -> 6 -> 7)

T.C. = O(n)

*/
import java.util.*;

public class ConsecutiveInteger {

    public static void main(String args[]) {

        int ans1[] = rearrange(7, 4);
        int ans2[] = rearrange(10, 3);
        print(ans1);
        print(ans2);

    }

    private static void print(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static int[] rearrange(int n, int k) {
        int ans[] = new int[n];

        int left = 1, right = n; // we will start filling from left then again from right and continue like this
        // filling the array in interval of k, as to maintain the sum
        int index = 0;
        int nextIndex = 1;
        boolean direction = true; // filling from 1 to n, if false then filling from n to 1
        while(left <= right) {
            while(index < ans.length) {
                ans[index] = (direction==true) ? left++ : right--;
                index = index + k;
            }

            index = nextIndex;
            nextIndex++;
            direction = (!direction); // reversing the direction of filling 
        }

        return ans;
    }
}