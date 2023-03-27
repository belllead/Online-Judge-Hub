import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] memo1 = new int[41];
	static int[] memo0 = new int[41];
	static {
		memo1[0] = 0;
		memo0[0] = 1;
		
		memo1[1] = 1;
		memo0[1] = 0;
		
		memo1[2] = 1; // memo1[0] + memo1[1] 
		memo0[2] = 1; // memo0[0] + memo0[1]
		
		memo1[3] = 2; // memo1[1] + memo1[2]
		memo0[3] = 1; // memo0[1] + memo0[2]
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(fibo0(N) + " " + fibo1(N) + "\n");
		}
		
		System.out.println(sb);
	}
	
	
	
	static int fibo1(int n) {
		if (n >= 4 && memo1[n] == 0) {
			memo1[n] = fibo1(n-1) + fibo1(n-2);
		}
		return memo1[n];
	}
	
	static int fibo0(int n) {
		if (n >= 4 && memo0[n] == 0) {
			memo0[n] = fibo0(n-1) + fibo0(n-2);
		}
		return memo0[n];
	}
}