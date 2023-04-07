import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] exclude = new int[M];
			
			for (int i=0; i<M; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				
				exclude[i] = ((1<<a) | (1<<b));
			}
			
			int cnt = 0;
			
			outer: for (int i=0; i<(1<<N); i++) {
				for (int ex=0; ex<M; ex++) {
					if ((i & exclude[ex]) == exclude[ex]) continue outer;
				}
				
				cnt++;
			}

			sb.append("#" + tc + " ");
			sb.append(cnt);
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	
}