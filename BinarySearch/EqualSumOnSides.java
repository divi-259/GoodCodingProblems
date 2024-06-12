import java.util.*;

/*
Question:
Given an interger N, return the integer number K in a way that the sum that goes from 1 to K-1 is equals to the sum that goes form k+1 to N (all inclusive), if there is no number that met the condition return -1.
Example.
Input.
N = 8
Output
K = 6

Explanation:
[1,2,3,4,5,6,7,8]
LEFT = SUM(1,K-1) = 1 + 2 + 3 + 4 +5 = 15
RIGHT = SUM(K+1,N) = 7 + 8 = 15
LEFT == RIGHT = TRUE

Question reference link: Leetcode https://leetcode.com/discuss/interview-question/5276400/AMAZON-SDE-FULL-TIME-PHONE-SCREEN-(ACCEPTED-TO-FINAL-INTERVIEW) 
*/

class EqualSumOnSides {

    public static void main(String[] args) {
        int test[] = {1,2,3,4,5,6,7,8,22,992,1000};
        for(int testcase : test) {
            System.out.println("The number dividing the array equally for " + testcase + " is " + getInteger(testcase));
        }
    }

    private static int getInteger(int n) {
        // the idea is to use the discrete binary search in a manner to find the k
        // we will create a function which will return us the sum of left and sum of right
        // and we can use that to check our condition and find out the number

        int lo = 0, hi = n-1;
        while(lo<hi) {
            int mid = lo + (hi-lo)/2;
            int left = getSum(1, mid-1);
            int right = getSum(mid+1, n-mid);
            if(left == right)
                return mid;
            if(left < right) {
                lo = mid+1;
            } 
            else hi = mid-1;
        }
        return -1;
        /* Alternate solution - calculate k directly
            sum of left = sum of right
            k*(k-1)/2 = (n(n+1)/2) - k*(k+1)/2;
            k = sqrt(n*(n-1))/2;
        */
    }

    private static int getSum(int a, int n) {
        return (n*(2*a + (n-1)))/2; // AP sum
    }


}