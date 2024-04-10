import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FPPSGenerator {

    public static void main(String[] args) {
        int numberOfElements = 10; // Specify the number of elements in the FPPS sequence you wish to compute.
        generateFPPSSequence(numberOfElements).forEach(System.out::println);
    }

    private static List<Integer> generateFPPSSequence(int numberOfElements) {
        List<Integer> fppsSequence = new ArrayList<>();
        int count = 0;
        int num = 2; // Starting from the first prime number.

        while (count < numberOfElements) {
            if (isPrime(num)) {
                BigInteger factorial = calculateFactorial(num);
                int sumOfDigits = sumDigits(factorial);
                fppsSequence.add(sumOfDigits);
                count++;
            }
            num++;
        }

        return fppsSequence;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static BigInteger calculateFactorial(int number) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    private static int sumDigits(BigInteger number) {
        int sum = 0;
        String numberStr = number.toString();
        for (int i = 0; i < numberStr.length(); i++) {
            sum += numberStr.charAt(i) - '0';
        }
        return sum;
    }
}

