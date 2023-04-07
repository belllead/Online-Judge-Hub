import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
				
		int limit = 1000000;
		
		int[] num = new int[limit+1];
		
		for (int i=2; i<=limit; i++) {
			num[i] = i;
		}
		
		for (int i=2; i<=limit; i++) {
			if (num[i] == 0) continue;
			
			for (int j=i*2; j<=limit; j+=i) {
				num[j] = 0;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=M; i<=N; i++) {
			if (num[i] != 0)
				sb.append(i + "\n");
		}
		
		System.out.println(sb);
		sc.close();
	}
}