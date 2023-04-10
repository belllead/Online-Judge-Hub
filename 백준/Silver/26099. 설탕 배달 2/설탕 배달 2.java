import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        sc.close();

        BigInteger three = BigInteger.valueOf(3);
        BigInteger five = BigInteger.valueOf(5);
        BigInteger zero = BigInteger.ZERO;

        if (n.mod(five).equals(zero)) {
            System.out.println(n.divide(five));
        } else if (n.mod(five).equals(three)) {
            System.out.println(n.divide(five).add(BigInteger.ONE));
        } else {
            BigInteger count = BigInteger.ZERO;
            while (n.compareTo(zero) >= 0) {
                n = n.subtract(three);
                count = count.add(BigInteger.ONE);
                if (n.mod(five).equals(zero)) {
                    count = count.add(n.divide(five));
                    System.out.println(count);
                    break;
                }
            }
            if (n.compareTo(zero) < 0) {
                System.out.println(-1);
            }
        }
    }
}