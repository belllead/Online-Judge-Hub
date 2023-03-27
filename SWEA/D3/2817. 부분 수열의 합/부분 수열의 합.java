import java.util.Scanner;

public class Solution {

	static int[] A;
	static int N, K, cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			
			N = sc.nextInt();
			K = sc.nextInt();
			
			A = new int[N];
			
			for (int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			
			cnt = 0;
			combi(0, 0);
			
			sb.append("#" + tc + " ");
			sb.append(cnt);
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	
	static void combi(int idx, int sum) {
		if (sum == K) {
			cnt++;
			return;
		}
		
		if (sum > K)
			return;
		
		if (idx >= N)
			return;
		
		combi(idx+1, sum+A[idx]);
		combi(idx+1, sum);
	}
}