import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited = new boolean[1000001];
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		System.out.println(bfs(N));		
	}

	static int bfs(int N) {
		if (N == K)
			return 0;
		
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(N);
		visited[N] = true;
		
		int cnt = 0;

		while (!q.isEmpty()) {

			int size = q.size();
			cnt++;
			
			while (size-- > 0) {
				int pos = q.poll();

				int t1 = pos - 1;
				int t2 = pos + 1;
				int t3 = pos * 2;
				
				if (t1 == K || t2 == K || t3 == K)
					return cnt;
				
				if (t1 >= 0 && t1 <= 1000000 && !visited[t1]) {
					q.offer(t1);
					visited[t1] = true;
				}
					
				if (t2 >= 0 && t2 <= 1000000 && !visited[t2]) {
					q.offer(t2);
					visited[t2] = true;
				}
				
				if (t3 >= 0 && t3 <= 1000000 && !visited[t3]) {
					q.offer(t3);
					visited[t3] = true;
				}
			}
		}

		return 0;
	}
}