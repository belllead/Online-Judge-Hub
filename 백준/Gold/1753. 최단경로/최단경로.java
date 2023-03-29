package baeckjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestWay1753 {
	
	static class Edge implements Comparable<Edge> {
		int target;
		int weight;
		
		public Edge(int target, int weight) {
			super();
			this.target = target;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int V, start;
	static List<Edge>[] adjList; 
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[V+1];
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for (int i=0; i<V+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new Edge(e, w));
		}
		
		dijkstra();
		
		for (int i=1; i<V+1; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}
	
	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		pq.offer(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if (visited[curr.target]) continue;

			visited[start] = true;
				
			for (Edge next : adjList[curr.target]) {
				
				if (distance[next.target] > distance[curr.target] + next.weight) {
					distance[next.target] = distance[curr.target] + next.weight;
					pq.offer(new Edge(next.target, distance[next.target]));
				}
			}
		}
	}
}


