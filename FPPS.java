import java.util.ArrayList;

public class FPPS {

    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to generate the FPPS sequence up to a given number of elements
    public static ArrayList<Integer> fppsSequence(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        primes.add(2);
        int i = 3;
        while (sequence.size() < n) {
            if (isPrime(i)) {
                primes.add(i);
                int factorial = 1;
                for (int j = 1; j <= i; j++) {
                    factorial *= j;
                }
                int digitSum = 0;
                int temp = factorial;
                while (temp > 0) {
                    digitSum += temp % 10;
                    temp /= 10;
                }
                sequence.add(digitSum);
            }
            i += 2; // Only check odd numbers for efficiency
        }
        return sequence;
    }

    // Example usage:
    public static void main(String[] args) {
        ArrayList<Integer> fpps = fppsSequence(20);
        System.out.println("First 20 FPPS numbers: " + fpps);
    }
}
