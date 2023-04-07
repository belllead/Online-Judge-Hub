import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		List<Integer>[] adjList = new ArrayList[N+1];
		for (int i=0; i<N+1; i++)
			adjList[i] = new ArrayList<>();
		
		for (int i=0; i<N-1; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			adjList[s].add(e);
			adjList[e].add(s);
		}
		
		int[] parent = new int[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];

		q.offer(1);
		visited[1] = true;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int n : adjList[curr]) {
				if (!visited[n]) {
					q.offer(n);
					parent[n] = curr;
					visited[n] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=2; i<N+1; i++)
			sb.append(parent[i]).append("\n");

		System.out.println(sb);
		sc.close();
	}
}