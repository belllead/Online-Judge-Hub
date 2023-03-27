import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextInt();
		long B = sc.nextInt();
		
		System.out.println(A * B / GCD(A, B));
		sc.close();
	}
	
	static long GCD(long a, long b) {
		if (a % b == 0)
			return b;
		
		return GCD(b, a % b);		
	}
}