import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static boolean[] visitedDfs;
	static boolean[] visitedBfs;
	static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		visitedDfs = new boolean[N+1];
		visitedBfs = new boolean[N+1];
		
		for (int i=0; i<N+1; i++) 
			adjList[i] = new ArrayList<Integer>();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for (ArrayList<Integer> a : adjList)
			Collections.sort(a);
		
//		for (ArrayList<Integer> a : adjList)
//			System.out.println(a);
		
		dfs(V);
		System.out.println();
		bfs(V);
		
	}
	
	static void dfs(int vertex) {
		visitedDfs[vertex] = true;
		System.out.print(vertex + " ");
		
		for (int a : adjList[vertex]) {
			if (!visitedDfs[a])
				dfs(a);
		}		
	}
	
	static void bfs(int vertex) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(vertex);
		visitedBfs[vertex] = true;
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			
			for (int a : adjList[temp]) {
				if (!visitedBfs[a]) {
					q.offer(a);
					visitedBfs[a] = true;
				}				
			}
		}
	}
	
}