import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(fibonacci(N));
		sc.close();
	}
	
	static int fibonacci(int n)	 {
		if (n == 0)
			return 0;
		
		else if (n == 1)
			return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}
}