import java.util.*;

/* Problem Statement: You have given a string with repeated characters, remove minimum number of characters of substring such that remaining string will have only unique characters.
Input1 : abcbbde
Output1 : 2, bb - substring which can be removed and the remaining character abcde is a unique string.
Input2 : aaabcdaa
Output2: 7, aaabcda - all these characters has to be removed such that remaining string a will have only unique characters.*/

class RepeatedChars {
    public static void main(String args[]) {
        String testarr[] = {"aaabcdaa", "abcbbde", "aabbccd", "abcde", "aaaaa", "a", "aazzz", "aa"};
        for(String str : testarr) {
            System.out.println("Number of chars to be removed in " + str + " is " + uniqueChars(str) );
        }
    }

    private static int uniqueChars(String str) {
        //  Base case
        if(str.length()==1)
            return 0;
        HashSet<Character> hset = new HashSet<>();
        int i=0, j=str.length()-1;

        // we are shortening the string length from both the ends, and whatever we are left with we are returning its length            
        while(i<j && !hset.contains(str.charAt(i))) {
            hset.add(str.charAt(i));
            i++;
        }
        while(i<j && !hset.contains(str.charAt(j))) {
            hset.add(str.charAt(j));
            j--;
        }
        return j-i+1;          
    }
}