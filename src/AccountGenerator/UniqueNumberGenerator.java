package AccountGenerator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueNumberGenerator {
    private static final Set<Integer> generatedNumbers = new HashSet<>();
    private static final int NUM_DIGITS = 8;

    public static int generateUniqueNumber() {
        if (generatedNumbers.size() >= Math.pow(10, NUM_DIGITS)) {
            throw new IllegalStateException("All possible unique numbers have been generated.");
        }

        Random random = new Random();
        int uniqueNumber;

        do {
            uniqueNumber = random.nextInt((int) Math.pow(10, NUM_DIGITS));
        } while (generatedNumbers.contains(uniqueNumber));

        generatedNumbers.add(uniqueNumber);
        return uniqueNumber;
    }

//    public static void main(String[] args) {
//        int uniqueNumber = generateUniqueNumber();
//        System.out.println("Generated unique number: " + uniqueNumber);
//    }
}
