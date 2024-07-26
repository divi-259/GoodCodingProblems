/*
Google Interview Question
Link: https://techdevguide.withgoogle.com/resources/former-interview-question-find-longest-word/#!

Given a string S and a set of words D, find the longest word in D that is a subsequence of S.

Word W is a subsequence of S if some number of characters, possibly zero, can be deleted from S to form W, without reordering the remaining characters.

Note: D can appear in any format (list, hash table, prefix tree, etc.

For example, given the input of S = "abppplee" and D = {"able", "ale", "apple", "bale", "kangaroo"} the correct output would be "apple"

The words "able" and "ale" are both subsequences of S, but they are shorter than "apple".
The word "bale" is not a subsequence of S because even though S has all the right letters, they are not in the right order.
The word "kangaroo" is the longest word in D, but it isn't a subsequence of S.

*/

class FindLongestWord {

    public static void main(String args[]) {
        String words[] = {"able", "ale", "apple", "bale", "kangaroo", "abpple"};
        String str = "abppplee";
        System.out.println("Longest word is = " + findLongest(words, str));

    }

    private static String findLongest(String[] words, String str) {
        int maxlen = 0; String ans="";
        for(String word : words) {
            int len = subseqlen(word, str);
            if(len > maxlen) {
                ans = word;
                maxlen = len;
            }
        }
        return ans;
    }

    private static int subseqlen (String a, String b) {
        int len = 0;
        int m = a.length();
        int n = b.length();
        if(m < n)
            return subseqlen(b,a);
        int dp[][] = new int[2][n+1];
        // Space efficient DP solution - only 2D array is taken and we are switching between rows to create the answer
        int i = 1;
        for(i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(a.charAt(i-1)==b.charAt(j-1))
                    dp[i%2][j] = dp[1-i%2][j-1] + 1;
                else dp[i%2][j] = Math.max(dp[1-i%2][j], dp[i%2][j-1]);
            }
        }

        return dp[i%2][n];
    }

}