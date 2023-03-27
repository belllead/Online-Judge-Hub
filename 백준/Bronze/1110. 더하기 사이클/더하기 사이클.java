import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if (N < 10) N *= 10;

		int test = N;
		
		int cnt = 0;
		while (true) {
			int tempNum = (test / 10) + (test % 10);
			int newNum = (test % 10) * 10 + (tempNum % 10);
			
			test = newNum;
			cnt++;
			
			if (newNum == N)
				break;
		}
		
		System.out.println(cnt);
		sc.close();
	}
}