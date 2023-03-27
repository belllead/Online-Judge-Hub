import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adjList;
	static int K;
	static List<Integer> ans = new ArrayList<>();
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		
		for (int i=0; i<N+1; i++) 
			adjList[i] = new ArrayList<>();
		
		visited = new boolean[N+1];
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
		}
		
//		for (List<Integer> l : adjList)
//			System.out.println(l);
		
		bfs(X);
		
		Collections.sort(ans);
		
		if (ans.size() == 0)
			System.out.println(-1);
		else {
			for (int i : ans)
				System.out.println(i);
		}
		
	}
	
	static void bfs(int X) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(X);
		visited[X] = true;
		
		int distance = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			distance++;
			
			while (size-- > 0) {
				int city = q.poll();
				for (int i : adjList[city]) {
					if (!visited[i]) {
						q.offer(i);
						visited[i] = true;
					}
				}
			}
			
			
			if (distance == K) {
				while(!q.isEmpty()) {
					ans.add(q.poll());
				}
			}
		}
		
		
	}
	
}