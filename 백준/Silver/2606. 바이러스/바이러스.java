import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[N+1];
		for (int i=0; i<N+1; i++)
			adjList[i] = new ArrayList<>();
		
		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		q.offer(1);
		visited[1] = true;
		
		while (!q.isEmpty()) {
			int contam = q.poll();
			
			for (int i : adjList[contam]) {
				if (!visited[i]) {
					q.offer(i);
					visited[i] = true;					
				}
			}
		}
		
		int cnt = 0;
		
		for (int i=0; i<N+1; i++) {
			if (visited[i])
				cnt++;
		}
		
		System.out.println(cnt-1);
	}
}