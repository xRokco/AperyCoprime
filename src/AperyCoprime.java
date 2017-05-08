import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rokco on 04/05/17.
 */
public class AperyCoprime {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int numCoprime = 0;
        int tests = 0;
        double percent = 101;
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < max; i = i + 1){
            int randomNum1 = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
            int randomNum2 = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
            int randomNum3 = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);

            tests++;
            if(Math.ceil(((double) tests/max)*100) != percent){
                percent = Math.ceil(((double) tests / max) * 100);
                System.out.print(percent + "% complete\r");
            }

            if(relativelyPrime(randomNum1, randomNum2, randomNum3)) {
                numCoprime++;
            }
        }

        double apery = (double) tests/numCoprime;

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        System.out.println("Number of tests: " + tests);
        System.out.println("Number of coprimes found: " + numCoprime);
        System.out.println("Apery Constant approximated: " + apery);

        System.out.println("Completed in " + elapsedTime/1000.00 + " seconds");
    }

    private static int gcd(int a, int b) {
        int t;
        while(b != 0){
            t = a;
            a = b;
            b = t%b;
        }
        return a;
    }

    private static boolean relativelyPrime(int a, int b, int c) {
        return gcd(a,gcd(b, c)) == 1;
    }
}
