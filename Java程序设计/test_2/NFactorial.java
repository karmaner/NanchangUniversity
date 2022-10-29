
import java.util.Scanner;
import java.math.BigInteger;

public class NFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger ans = BigInteger.ONE;
        for(int i = 1; i <= n; i++) {

            ans = ans.multiply(BigInteger.valueOf(i));
        }
        System.out.println(ans);
    }
}
