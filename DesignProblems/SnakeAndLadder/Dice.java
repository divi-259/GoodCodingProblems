import java.util.Random;

public class NormalDice implements Dice {
    @override
    public int rollDice() {
        Random random = new Random();
        return 1+randome.nextInt(6);
    }
}