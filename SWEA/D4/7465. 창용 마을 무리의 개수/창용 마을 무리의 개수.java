import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static List<Integer>[] adjList;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		InputStream is = new ByteArrayInputStream(input.getBytes());
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[N+1];
			
			for (int i=0; i<N+1; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adjList[a].add(b);
				adjList[b].add(a);
			}
			
			visited = new boolean[N+1];
			
			int cnt = 0;
			
			for (int i=1; i<N+1; i++) {
				if (!visited[i]) {
					bfs(i);
					cnt++;
				}
				
//				System.out.println(Arrays.toString(visited));
			}
			
//			System.out.println();
			
			sb.append("#" + tc + " ");
			sb.append(cnt);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int vertex) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(vertex);
		visited[vertex] = true;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int next : adjList[curr]) {
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
	}
	
	static String input = "2\r\n"
			+ "6 5\r\n"
			+ "1 2\r\n"
			+ "2 5\r\n"
			+ "5 1\r\n"
			+ "3 4\r\n"
			+ "4 6\r\n"
			+ "6 8\r\n"
			+ "1 2\r\n"
			+ "2 5\r\n"
			+ "5 1\r\n"
			+ "3 4\r\n"
			+ "4 6\r\n"
			+ "5 4\r\n"
			+ "2 4\r\n"
			+ "2 3";
}