import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Function that implements the sieve of Eratosthenes to find prime numbers.
     *
     * @param n Max numbers for the sieve (top limit)
     * @return A list that contain all prime numbers smaller than N
     * */
    public static Integer[] PrimeSieve(int n) {
        ArrayList<Integer> primeList = new ArrayList<>();

        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {

            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i])
                primeList.add(i);
        }

        return primeList.toArray(new Integer[0]);
    }

    /**
     * Function that check if a number is prime.
     *
     * @param n Number to check
     * @return True if it´s prime, and false if it´s not prime.
     * */
    public static boolean PrimeCheker(int n){

        if (n > 3){
            if (n % 2 == 0){
                return false;
            }
            else {

                for (int i = 3; i < n; i = i + 2) {
                    if (n % i == 0){
                        return false;
                    }
                }

                return true;
            }
        }
        else{
            return true;
        }
    }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int choice;

            while (true){
                System.out.println("\nWelcome to the finding primes program");
                System.out.println("(1) - Find primes within a max limit");
                System.out.println("(2) - Check if a number is prime");
                System.out.println("(3) - Exit");
                System.out.print("Select an option above:");
                try {
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Max limit: ");
                            int limit = sc.nextInt();
                            for (int i : PrimeSieve(limit)) {
                                System.out.println(i);
                            }
                            break;
                        case 2:
                            System.out.print("Number to check: ");
                            int num = sc.nextInt();
                            if (PrimeCheker(num)) {
                                System.out.println("\nIt´s a prime number");
                            } else {
                                System.out.println("\nNot a prime number");
                            }
                            break;
                        case 3:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("\nInvalid option");
                    }
                }
                catch (Exception e) {
                    System.out.println("\nInvalid option");
                    sc.nextLine();
                }
            }

            }
}
