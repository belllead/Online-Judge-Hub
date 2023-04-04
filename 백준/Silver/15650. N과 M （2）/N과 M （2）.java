import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N, M;
	static List<String> list = new ArrayList<>();
	static int[] s;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		s = new int[M];
		visited = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			visited[i] = true;
			s[0] = i;
			powerSet(i, 1);
			visited[i] = false;
		}
		
		System.out.println(sb);
		sc.close();
	}
	
	static void powerSet(int idx, int sidx) {
		if (sidx == M) {
			for (int i : s)
				sb.append(i + " ");
			sb.append("\n");
			return;
		}
		
		for (int i=s[sidx-1]+1; i<=N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				s[sidx] = i;
				powerSet(idx+1, sidx+1);
				visited[i] = false;
			}
		}
			
	
	}
}