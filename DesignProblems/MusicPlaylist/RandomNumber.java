
// The below class will help generate a random number between 1 to n.

import java.util.random;

public class RandomNumber {

    public static int getRandomNumber(int n) {
        Random random = new Random();
        return random.nextInt(n) + 1; // this will return a random number between 1 to n
        // it is not cryptographically secure but does the job

        // Another approach
        // return (int) (Math.random() * n) + 1;
    }

}