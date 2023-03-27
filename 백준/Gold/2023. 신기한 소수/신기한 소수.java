import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		fantasticPrime(0, N);
		
		System.out.println(sb);
		sc.close();
	}
	
	static void fantasticPrime(int a, int digit) {
		// 기저 조건
		if (digit == 0) {
			if (isPrime(a)) {
				sb.append(a + "\n");
			}
			return;
		}
		
		// 유도 파트
		for (int i=0; i<10; i++) {
			int nextDigit = a * 10 + i;
			if (isPrime(nextDigit))
				fantasticPrime(nextDigit, digit-1);
		}
		
			
	}
	
	static boolean isPrime(int a) {
		if (a <= 1) return false;
		
		else {
			for (int i=2; i<=Math.sqrt(a); i++) {
				if (a % i == 0)
					return false;
			}
		}
		
		return true;
			
	}
	
}