import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int ans = M - GCD(N, M);
		
		System.out.println(ans);
		sc.close();
		
	}
	
	static int GCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		else 
			return GCD(b, a % b);
	}
	
}