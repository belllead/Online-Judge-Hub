import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited = new boolean[100001];
	static int N, K;

	static class Seeker {
		int x;
		int time;
		
		public Seeker(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		System.out.println(bfs());		
	}

	static int bfs() {
		int minTime = Integer.MAX_VALUE;
		
		Queue<Seeker> q = new LinkedList<>();
		q.offer(new Seeker(N, 0));
		visited[N] = true;
		
		while (!q.isEmpty()) {
			Seeker seeker = q.poll();

			if (seeker.x == K) 
				minTime = Math.min(minTime, seeker.time);
			
			if (seeker.x * 2 <= 100000 && !visited[seeker.x * 2]) {
				q.offer(new Seeker(seeker.x * 2, seeker.time));
				visited[seeker.x * 2] = true;
			}

			if (seeker.x - 1 >= 0 && !visited[seeker.x - 1]) {
				q.offer(new Seeker(seeker.x - 1, seeker.time + 1));
				visited[seeker.x - 1] = true;
			}
			
			if (seeker.x + 1 <= 100000 && !visited[seeker.x + 1]) {
				q.offer(new Seeker(seeker.x + 1, seeker.time + 1));
				visited[seeker.x + 1] = true;
			}
		
		}
		return minTime;
	}
}