/*
You are asked with intercepting electronic signals. The very first step is to find the start message marker
in the stream of random data.
Start message markers occur after N unique code points (UTF-8) in the stream.
Input looks like this - NIStream
N is the length of start message marker.
N unique code points in a contiguous row from the start of the Stream.
I - is to differentiate that the stream is getting started.
N is always less than the length of the string and you are gauranteed to find a start message marker

Output: Return the index after the start message marker

Example:
3INJ3*FX=4)||Q
ans = 3, as NJ3 is a uniqe continguours chars

another example
2IA\<;A
K#Z

above string includes a vertical tab

*/
import java.util.*;
class SignalsIntelligence {
    public static void main(String args[]) {
        String inp[] = {"3INJ3*FX=4)||Q", "4INJ3*FX=4)||Q", "2IA<;AK#Z", "8In^Well$2eS3(sg37I7e6WVEX2_i=T-M)"};

        for(String test : inp) {
            System.out.println(test + " " + getIndexAfterMarker(test));
        }
    }

    private static int getIndexAfterMarker(String str) {
        int i =0,j=0;
        while(str.charAt(j)!='I') {
            j++;
        }
        int len = Integer.valueOf(str.substring(i,j));

        HashSet<Character> hset = new HashSet<>();
        for(i=j+1; i<str.length(); i++) {
            //System.out.println("Inside" + hset);
            char ch = str.charAt(i);
            if(hset.contains(ch)) {
                hset.clear();
            }
            hset.add(ch);
            if(hset.size()==len)
                return i-j+1;
        }
        return -1;
    }
}