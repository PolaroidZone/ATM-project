package AccountGenerator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueNumberGenerator {
    private static final Set<Integer> generatedNumbers = new HashSet<>();
    private static final int NUM_DIGITS = 8;
    private static final int NUM_DIGITS_CARD = 16;

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

    public static int generateUniqueCard() {
        if (generatedNumbers.size() >= Math.pow(10, NUM_DIGITS_CARD)) {
            throw new IllegalStateException("All possible unique numbers have been generated.");
        }

        Random random = new Random();
        int uniqueNumber;

        do {
            uniqueNumber = random.nextInt((int) Math.pow(10, NUM_DIGITS_CARD));
        } while (generatedNumbers.contains(uniqueNumber));

        generatedNumbers.add(uniqueNumber);
        return uniqueNumber;
    }


    public static String convertScientificToDecimal(double scientificNumber) {
        // Convert the scientific notation to a full decimal string
        String decimalString = String.format("%.10f", scientificNumber);

        // Remove trailing zeros
        decimalString = decimalString.replaceAll("0*$", "");

        // Remove decimal point if there are no decimal places left
        decimalString = decimalString.replaceAll("\\.$", "");

        return decimalString;
    }

}
